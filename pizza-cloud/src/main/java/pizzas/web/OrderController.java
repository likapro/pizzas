package pizzas.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pizzas.PizzaOrder;
import pizzas.User;
import pizzas.data.OrderRepository;
import pizzas.data.UserRepository;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {

    private OrderRepository orderRepo;
    private UserRepository userRepository;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) return "orderForm";

        log.info("Order submitted: {}", order);
        orderRepo.save(order);
        sessionStatus.setComplete();

        //User user = userRepository.findByUsername(principal.getName());
        //User user = (User) authentication.getPrincipal();
        order.setUser(user);

        return "redirect:/";
    }
}

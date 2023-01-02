package pizzas.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pizzas.PizzaOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderContrioller {

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(PizzaOrder order, SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}

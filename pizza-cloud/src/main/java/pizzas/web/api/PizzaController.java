package pizzas.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizzas.Pizza;
import pizzas.data.PizzaRepository;

@RestController
@RequestMapping(path = "/api/pazzas", produces = "application/json")
@CrossOrigin(origins = "http://pizzacloud:8080")
public class PizzaController {
    private PizzaRepository pizzaRepo;

    public PizzaController(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @GetMapping(params = "recent")
    public Iterable<Pizza> recentPizzas() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return pizzaRepo.findAll(page).getContent();
    }
}

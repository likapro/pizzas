package pizzas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pizzas.data.IngredientRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

//    @ModelAttribute
//    public void addIngredientsToModel(Model model) {
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", WRAP),
//                new Ingredient("COTO", "Corn Tortilla", WRAP),
//                new Ingredient("GRBF", "Ground Beef", PROTEIN),
//                new Ingredient("CARN", "Carnitas", PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", VEGGIES),
//                new Ingredient("LETC", "Lettuce", VEGGIES),
//                new Ingredient("CHED", "Cheddar", CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", CHEESE),
//                new Ingredient("SLSA", "Salsa", SAUCE),
//                new Ingredient("SRCR", "Sour Cream", SAUCE));
//
//        Ingredient.Type[] types = Ingredient.Type.values();
//        for (Ingredient.Type type : types) {
//            model.addAttribute(type.toString().toLowerCase(),
//            filterByType(ingredients, type));
//        }
//    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order() {
        return new PizzaOrder();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignFrom() {
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors errors, @ModelAttribute PizzaOrder pizzaOrder) {
        if (errors.hasErrors()) return "design";

        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}

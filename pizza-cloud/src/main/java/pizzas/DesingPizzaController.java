package pizzas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesingPizzaController {

    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP), new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP), new Ingredient("GRBF", "Ground Beef", Ingredient.Type.WRAP), new Ingredient("CARN", "Carnitas", Ingredient.Type.WRAP), new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.WRAP), new Ingredient("LETC", "Lettuce", Ingredient.Type.WRAP), new Ingredient("CHED", "Cheddar", Ingredient.Type.WRAP), new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.WRAP), new Ingredient("SLSA", "Salsa", Ingredient.Type.WRAP), new Ingredient("SRCR", "Sour Cream", Ingredient.Type.WRAP));

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients, type));
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

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}

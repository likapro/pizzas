package pizzas.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pizzas.Ingredient;

import java.util.HashMap;
import java.util.Map;

import static pizzas.Ingredient.Type.*;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", WRAP));
        ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", PROTEIN));
        ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", PROTEIN));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", CHEESE));
        ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", SAUCE));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Ingredient, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}

package pizzas.data;

import org.springframework.data.repository.CrudRepository;
import pizzas.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}

package pizzas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pizzas.data.IngredientRepository;
import pizzas.data.PizzaRepository;

import java.util.Arrays;

@SpringBootApplication
public class PizzaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo, PizzaRepository pizzaRepo) {
		return args -> {
			Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
			Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP);
			Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
			Ingredient carnitas = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
			Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
			Ingredient lettuce = new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES);
			Ingredient cheddar = new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE);
			Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
			Ingredient salsa = new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE);
			Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE);
			repo.save(flourTortilla);
			repo.save(cornTortilla);
			repo.save(groundBeef);
			repo.save(carnitas);
			repo.save(tomatoes);
			repo.save(lettuce);
			repo.save(cheddar);
			repo.save(jack);
			repo.save(salsa);
			repo.save(sourCream);

			Pizza pizza1 = new Pizza();
			pizza1.setName("питца1");
			pizza1.setIngredients(Arrays.asList(flourTortilla, groundBeef, salsa));
			pizzaRepo.save(pizza1);

			Pizza pizza2 = new Pizza();
			pizza2.setName("питца2");
			pizza2.setIngredients(Arrays.asList(flourTortilla, groundBeef, jack));
			pizzaRepo.save(pizza2);

			Pizza pizza3 = new Pizza();
			pizza3.setName("питца3");
			pizza3.setIngredients(Arrays.asList(flourTortilla, groundBeef, lettuce));
			pizzaRepo.save(pizza3);

		};
	}
}

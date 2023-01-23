package pizzas.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import pizzas.Pizza;

public interface PizzaRepository extends PagingAndSortingRepository<Pizza, Long> {
}

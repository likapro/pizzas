package pizzas.data;

import org.springframework.data.repository.CrudRepository;
import pizzas.PizzaOrder;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
}

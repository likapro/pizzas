package pizzas.data;

import org.springframework.data.repository.CrudRepository;
import pizzas.PizzaOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
    List<PizzaOrder> findByDeliveryZip(String deliveryZip);
}

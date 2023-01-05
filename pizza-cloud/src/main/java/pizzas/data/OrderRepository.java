package pizzas.data;

import pizzas.PizzaOrder;

public interface OrderRepository {
    PizzaOrder save(PizzaOrder order);
}

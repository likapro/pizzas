package pizzas;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiraton;
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPazza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}

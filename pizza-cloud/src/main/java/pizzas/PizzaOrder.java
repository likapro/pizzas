package pizzas;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
public class PizzaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @NotBlank
    private String deliveryName;
    @NotBlank
    private String deliveryStreet;
    @NotBlank
    private String deliveryCity;
    @NotBlank
    private String deliveryState;
    @NotBlank
    private String deliveryZip;
    //@CreditCardNumber
    private String ccNumber;
    //@Pattern(regexp="0-9*")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0)
    private String ccCVV;
    private Date placedAt;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}

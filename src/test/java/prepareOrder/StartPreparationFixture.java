package prepareOrder;

import manageOrder.*;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class StartPreparationFixture {
    public Order createOrder(){
        Order result = new Order();
        Client client = new Client("Tom", "" );
        result.setClient(client);

        Pizza pizza1 = new Pizza(Size.XL, Crust.THIN);
        Pizza pizza2 = new Pizza(Size.MEDIUM, Crust.GLUTEN_FREE);
        result.addPizza(pizza1);
        result.addPizza(pizza2);
        return result;
    }

    public Order prepare (Order order){
        order.setStatus(Status.InPreparation);
        return order;
    }

    public String getStatus (Order order){
        return String.valueOf(order.getStatus());
    }

}

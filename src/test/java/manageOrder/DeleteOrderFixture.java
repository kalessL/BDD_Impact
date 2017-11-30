package manageOrder;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class DeleteOrderFixture {

    Client Tom = new Client("Tom", "");

    public Order createOrder() {
        Order tomOrder = new Order();
        Pizza pizza1 = new Pizza(Size.XL,Crust.THIN);
        tomOrder.addPizza(pizza1);
        Tom.addOrder(tomOrder);
        return tomOrder;
    }

    public String deleteOrder (Order clientOrder){
        String result;
        Tom.removeOrder(clientOrder);
        if (Tom.getOrder().isEmpty()){
            result = "deleted";
        } else {
            result="Fail";
        }
        return result;
    }

}

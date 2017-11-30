package manageOrder;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class CreateOrderFixture {

    public Order createOrder(){
        Order result = new Order();
        Client client = new Client("Tom", "" );
        result.setClient(client);

        Pizza pizza1 = new Pizza(Size.XL,Crust.THIN);
        result.addPizza(pizza1);
        return result;
    }

    public String getSize(Order clientOrder) {
        Pizza pizzaTest;
        pizzaTest = clientOrder.getPizzaList().get(0);
        String result = pizzaTest.getPizzaSize().name();
        return result;
    }

    public String getCrust(Order clientOrder) {
        Pizza pizzaTest;
        pizzaTest = clientOrder.getPizzaList().get(0);
        String result = pizzaTest.getPizzaCrust().name();
        return result;
    }

    public String orderStatus(Order clientOrder) {
        String result = String.valueOf(clientOrder.getStatus());
        return result;
    }


    public Pizza createPizza(String pizzaSize, String pizzaCrust, String pizzaTopping) {
        //System.out.println(pizzaSize+"_");
        pizzaSize = pizzaSize.substring(0, pizzaSize.length() - 1);
        Size size = Size.valueOf(pizzaSize);

        pizzaCrust = pizzaCrust.substring(0, pizzaCrust.length() - 1);
        Crust crust = Crust.valueOf(pizzaCrust);
        Pizza pizzaTest = new Pizza(size, crust);

        pizzaTopping = pizzaTopping.substring(0, pizzaTopping.length() - 1);
        //System.out.println(pizzaTopping+"_");
        pizzaTest.addTopping(Topping.valueOf(pizzaTopping));
        return pizzaTest;
    }

    public double getPrice(Pizza pizza){
         return pizza.getPrice().getPrice();
    }
}

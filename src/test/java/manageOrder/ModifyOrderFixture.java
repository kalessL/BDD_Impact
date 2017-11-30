package manageOrder;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ModifyOrderFixture {

    public Drink drink = Drink.Coca;

    public Order createOrder() {
        Client Tom = new Client("Tom", "");
        Order tomOrder = new Order();
        Tom.addOrder(tomOrder);
        tomOrder.addDrink(drink);
        return tomOrder;
    }

    public String removedFrom(Order clientOrder){
        String result;

        clientOrder.removeDrink(drink);
        if (clientOrder.getDrinkList().contains(drink)) {
            result="Fail";
            // result = String.valueOf(clientOrder.getDrinkList().get(0));
        } else {
            result = "Drink";
        }
        return result;
    }

    public Result addedFrom(Order clientOrder){
        Result result = new Result();
        Pizza pizza1 = new Pizza(Size.XL,Crust.THIN);
        clientOrder.addPizza(pizza1);

        result.size = String.valueOf(clientOrder.getPizzaList().get(0).getPizzaSize());
        System.out.println(result.size);
        result.crust = String.valueOf(clientOrder.getPizzaList().get(0).getPizzaCrust());
        return result;
    }

    class Result {
        public String size;
        public String crust;
    }

}

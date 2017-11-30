package manageOrder;

import java.util.ArrayList;

public class Order {
    //Date date;
    private ArrayList<Pizza> pizzaList;
    private ArrayList<Drink> drinkList;
    private Client clientOwner = new Client();
    private Price price = new Price();
    private Status status = Status.New;
    private String time = "";

    public Order(){
        pizzaList = new ArrayList<Pizza>();
        drinkList = new ArrayList<Drink>();
    }

    public Client getClient(){
        return clientOwner;
    }

    public void setClient(Client client){
        this.clientOwner=client;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void addPizza(Pizza pizza){
        pizzaList.add(pizza);
    }

    public void removePizza(Pizza pizza){
        pizzaList.remove(pizza);
    }

    public void addDrink(Drink drink){
        drinkList.add(drink);
    }

    public void removeDrink(Drink drink){drinkList.remove(drink);}

    public String toString(){
        String result = "the order for "+ clientOwner.getName()+" has the following pizza: \n";

        for (int i=0; i<pizzaList.size();i++){
            result = result+"\t"+pizzaList.get(i).toSring()+"\n";
        }
        result = result+"And the following drinks:\n";

        for (int i=0; i<drinkList.size();i++){
            result = result+"\t"+drinkList.get(i).toString()+"\n";
        }
        return result;
    }

    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public ArrayList<Drink> getDrinkList() {
        return drinkList;
    }

    public Status getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public Price getPrice() {
        for (int i=0; i<pizzaList.size();i++){
            price.addPrice(
                    new Price(pizzaList.get(i).getPizzaSize(), pizzaList.get(i).getPizzaCrust(),pizzaList.get(i).getToppingList())
            );
        }
        for (int i=0; i<drinkList.size();i++){
            price.addPrice( new Price(drinkList.get(i)));
        }

        return price;
    }
}

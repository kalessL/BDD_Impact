package manageOrder;

import java.util.*;

public class Pizza {

    private Size pizzaSize;
    private Crust pizzaCrust;
    private ArrayList<Topping> toppingList;


    public Pizza(){
    }

    public Pizza(Size pizzaSize, Crust pizzaCrust){
        this.pizzaSize = pizzaSize;
        this.pizzaCrust = pizzaCrust;
        this.toppingList= new ArrayList<Topping>();
    }

    public void addTopping(Topping topping){
        toppingList.add(topping);
    }

    public void addManyTopping(Topping... topping){
        toppingList.addAll(Arrays.asList(topping));
    }


    public String toSring(){
        return "A "+pizzaSize+" with "+pizzaCrust+" crust " + "with topping: " + toppingList;
    }

    public Size getPizzaSize() {
        return pizzaSize;
    }

    public Crust getPizzaCrust() {
        return pizzaCrust;
    }

    public ArrayList<Topping> getToppingList() {
        return toppingList;
    }

    public Price getPrice() {
        return new Price(this.getPizzaSize(), this.getPizzaCrust(), this.getToppingList());
    }
}

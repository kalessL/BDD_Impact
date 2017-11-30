package manageOrder;

import java.util.ArrayList;

public class Price {
    private double price=0.0;

    public Price() {}

    protected Price(Size size, Crust crust, ArrayList<Topping> toppingList) {
        this.price = this.computePricePizza(size, crust, toppingList);
    }

    protected Price(Drink drink){
        this.price = this.computePriceDrink(drink);
    }



    private double computePricePizza(Size size, Crust crust, ArrayList<Topping> toppingList) {
        double result=0.0;
        switch (size) {
            case SMALL:
                result += 6;
                break;
            case MEDIUM:
                result += 7.5;
                break;
            case LARGE:
                result += 9;
                break;
            case XL:
                result+= 11;
                break;
        }

        switch (crust) {
            case CHEESE: result += 1.5;
            break;
            case GLUTEN_FREE: result += 1;
            break;
        }

        for (int j=0; j<toppingList.size();j++){
            result += 0.5;
        }
        return result;
    }

    private double computePriceDrink(Drink drink){
        double result=1;
        switch (drink) {
            case CocaBottle: result = 2;
            break;
        }
        return result;
    }

    public void addPrice(Price priceToAdd){
        this.price += priceToAdd.getPrice();
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

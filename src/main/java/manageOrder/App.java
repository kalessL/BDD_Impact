package manageOrder;


import java.sql.*;

public class App {

    public void addClient (){

    }

    public static void main(String[] args) {
        // Connection DB
        /*try {
            Connection connection = DBConnection.getInstance();

            Statement instruction = connection.createStatement();
            String ordre = "Select id, espece, date_naissance from animal";
            ResultSet rs = instruction.executeQuery(ordre);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date date_naissance = rs.getDate("date_naissance");
                String espece = rs.getString("espece");
                System.out.println(id + "\t" + date_naissance + "\t" + espece);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        Order orderTest = new Order();
        Pizza pizzaTest = new Pizza(Size.SMALL, Crust.CHEESE);

        pizzaTest.addManyTopping(Topping.HAM, Topping.GREEN_PEPPERS, Topping.PEPPERONI);

        orderTest.addPizza(pizzaTest);
        orderTest.addPizza(pizzaTest);

        Drink drinkTest = Drink.Coca;
        orderTest.addDrink(drinkTest);

        Client clientTest = new Client("Thomas","Lille");
        orderTest.setClient(clientTest);

        System.out.println(orderTest);

        System.out.println(orderTest.getStatus());
        System.out.println(pizzaTest.getPizzaSize());

        Price price = pizzaTest.getPrice();
        System.out.println(price.getPrice());

        // addPrice test
        price.addPrice(pizzaTest.getPrice());
        System.out.println(price.getPrice());

        System.out.println(orderTest.getPrice().getPrice());
    }


}

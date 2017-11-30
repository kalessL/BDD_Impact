package manageOrder;

import java.util.ArrayList;

public class Client {
    private String name;
    private String address;
    private ArrayList<Order> orderList = new ArrayList<Order>();

    public Client(){}

    public Client(String name,String address){
        this.address=address;
        this.name=name;
    }

    public ArrayList<Order> getOrder() {
        return orderList;
    }

    public void removeOrder(Order order){
        orderList.remove(order);
    }

    public void addOrder(Order order){
        if (!orderList.contains(order)){
            if (order.getClient() !=null) order.getClient().removeOrder(order);
            order.setClient(this);
            orderList.add(order);
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

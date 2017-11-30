package manageOrder;

public class Node {
    Node nextNode;           //reference to next node in chain. null if none
    Order order; //data carried by this node

    //Default Constructor
    public Node(Order reservation) {
        nextNode = null;
        order = reservation;
    }


    //Getters
    public Order getOrder(){return order;  }
    public Node getNextNode(){return nextNode; }

    //Setters
    public void setOrder(Order order){this.order = order;  }
    public void setNextNode(Node nextNode){this.nextNode = nextNode;}
}

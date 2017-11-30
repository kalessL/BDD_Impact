package manageOrder;

import java.util.NoSuchElementException;

public class OrderLinkedList {
    private Node head;
    private int listCount;


    public OrderLinkedList() {
        //this is an empty list, so the reference to the head mode
        //is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }

    //append object to the end of the list
    public void append(Order order) {
        Node listTemp = new Node(order);
        Node listCurrent = head;

        //starting at the head node, crawl to the end of the list
        while(listCurrent.getNextNode() != null)
        {
            listCurrent = listCurrent.getNextNode();
        }

        listCurrent.setNextNode(listTemp);
        listCount++;
    }

    public boolean isEmpty() {
        if(listCount == 0) {
            return true;
        } else {
            return false;
        }
    }

    //removes element at specified index
    public boolean removeIndex(int index) {
        Node listCurrent = head;
        for (int i = 1; i < index; i++)
        {
            if(listCurrent.getNextNode() == null)
                return false;

            listCurrent = listCurrent.getNextNode();
        }
        //connects current Node with succeding Node
        listCurrent.setNextNode(listCurrent.getNextNode().getNextNode());
        listCount--; //decrements the number of elements in the list
        return true;
    }

    //returns the amount of nodes in the list
    public int size()
    {
        return listCount;
    }

    //allows me to access elements in the linked list
    public Order get(int index) {
        // index must be 1 or higher
        if(index < 0)
            return null;

        Node current = head.getNextNode();
        for(int i = 0; i < index; i++)
        {
            if(current.getNextNode() == null)
                return null;

            current = current.getNextNode();
        }
        return current.getOrder();
    }

    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    //This class defines the linked
    //list iterator, used to insert
    //nodes in the correct position

    class LinkedListIterator implements ListIterator {
        //3 instance variables
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        @Override
        public Order next()
        {
            if (!hasNext()) { throw new NoSuchElementException(); }
            isAfterNext = true;

            if (position == null) {
                position = head;
            } else {
                position = position.nextNode;
            }

            return position.order;
        }

        @Override
        public boolean hasNext()
        {
            if (position == null) {
                return head != null;
            } else {
                return position.nextNode != null;
            }
        }

        public void makeNewReservation(Order element)
        {
            if(isEmpty()) {
                //System.out.println("Added to empty list");
                add(element); //add method has an exception for empty list
            }
            else
            {
                position = head;
                for (int i = 0; i < size(); i++)
                {
                    String eTime = element.getTime().replaceAll(":", "");
                    String pTime = position.nextNode.order.getTime().replaceAll(":", "");

                    int eTimeInt = Integer.parseInt(eTime);
                    int pTimeInt = Integer.parseInt(pTime);


                    if(i == (size()-1) && pTimeInt < eTimeInt)
                    {
                        append(element);
                        break;
                    }

                    if(pTimeInt >= eTimeInt)
                    {
                        //System.out.println("Added by comparison");
                        add(element);
                        break;
                    }
                    else
                        next();
                }
            }
        }

        @Override
        public void add(Order element)
        {
            if(position == null) //if list is empty, append new element
            {
                append(element);
                position = head;
            }
            else//otherwise, append according to date/time comparison
            {
                Node newNode = new Node(null);  //create new node
                newNode.order = element;      //assign parameter to node's data
                newNode.nextNode = position.nextNode; //node points to next node in chain
                position.nextNode = newNode;          //current pointer points to new node
                position = newNode;                   //current IS the new node
                listCount++;
                //System.out.println("Added from ListIterator");
            }

            isAfterNext = false;
        }

        @Override
        public void remove()
        {
            if(!isAfterNext) { throw new IllegalStateException(); }
            if(position == head)
            {
                removeIndex(0);
            }
            else
            {
                previous.nextNode = position.nextNode;
            }
            position = previous;
            isAfterNext = false;
            listCount--;
        }

        @Override
        public void set(Order element)
        {
            if(!isAfterNext) { throw new IllegalStateException(); }
            position.order = element;
        }
    }




}

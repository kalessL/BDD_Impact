package manageOrder;

public interface ListIterator {
    //move iterator past the next element
    //return traversed element
    Order next();

    //tests if there is an element after position
    //return true if such element exists
    boolean hasNext();

    //adds ane element before the iterator position
    //moves the iterator past inserted element
    //parameter = element to add
    void add(Order element);

    //Removes the last traversed element.
    //This method can only be called after call to next method
    void remove();

    //Places new reservation at the correct spot
    void makeNewReservation(Order element);

    //Sets the last traversed element to a different value
    //parameter = element to set
    void set(Order element);
}

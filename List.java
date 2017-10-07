/**
 * This List class creates a linked list of Generics that can store instances
 * of the generic T once declared and the location of the next node in the
 * linked list.
 *
 * Exception handling is done by the methods of this class, no handling of
 * LinkedList exceptions should be required by classes calling this class.
 *
 * @author Calvin Evans
 * @version 7/27/2017
 */
public class List<T> {

    /**
     * This internal class creates the nodes that store the data(Object) and
     * the pointer to the next node. This class has no function other than
     * data storage.
     */
    private class Node {
        private T data;
        private Node next;
    }

    private Node head;//the first Object in the linked list.

    /**
     * Default constructor: All internal data is set to null.
     */
    public List() {
        head = null;
    }

    /**
     * Pre: Takes in an object of any type.
     * Post: Creates a List object with the input Object as the head.
     *
     * @param obj an Object of any type to be stored in the first location of
     *            the linked list.
     */
    public List(T obj) {
        head = new Node();
        head.data = obj;
        head.next = null;
    }

    /**
     * Pre: none
     * Post: Iterates through the entire linked list and counts each node.
     *
     * @return returns an int value of the total number of nodes counted.
     */
    public int size() {
        Node pointer = head;
        int counter = 1;
        if (head == null) {
            return 0;
        }
        while (pointer.next != null) {//iterates the counter each time the
            // pointer lands on a new node. Ends when the pointer is on the
            // last node in the linked list.
            counter++;
            pointer = pointer.next;
        }
        return counter;
    }

    /**
     * Getter: Gets a pointer to the data stored at the index location. This
     * is a shallow copy to allow the data at that location to be modified or
     * marked for removal.
     * @param index an int for the index location to retrieve the data of
     * @return a shallow copy of the <T> stored at the desired index
     * location.
     */
    protected T getData(int index){
        T output = null;
        try {
            if (!this.checkIndex(index)) {//checking for valid input
                if (head.next == null) {//removes head object and sets List
                    // to default.
                    output = head.data;
                } else if (index == 0) {//removes object stored in head and
                    // sets object at index 1 as the new head
                    output = this.head.data;
                    return output;
                } else {//iterates through the linked list to the index
                    // location, removes and returns the Object at the
                    // requested index.
                    Node pointer = head;
                    for (int i = 0; i <= index; i++) {
                        if (i == index) {
                            output = pointer.data;
                        } else if (i == index - 1) {
                            pointer = pointer.next;
                        } else {
                            pointer = pointer.next;
                        }
                    }
                }
            }
        } catch (PizzaException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return output;
    }

    /**
     * Pre: Takes in an object to be stored in a new Node and an index
     * location to place the node at as an int
     * Post: Checks that the index location is valid, if the location is
     * outside of the range of the index (less than 0 or greater than the
     * current size) an exception will be thrown and a message output. If the
     * index is valid, the new Node is created with the input Object stored
     * in it and it is placed at the desired index location.
     *
     * @param obj   an Object of any type to be stored in the given index
     *              location
     * @param index an int between 0 and the current size of the linked list.
     */
    public void insert(T obj, int index) {
        try {
            if (!this.checkIndex(index)) {//checking for valid input
                Node pointer = head;
                if (pointer == null) {//required to instantiate a List
                    // created with the default constructor
                    head = new Node();
                    head.data = obj;
                    head.next = null;
                } else if (index == 0) {//required to populate an empty List
                    Node input = new Node();
                    input.data = obj;
                    input.next = head;
                    head = input;
                } else {
                    for (int i = 0; i < index; i++) {//iterates to the index
                        // location and then places the new Node in that
                        // location
                        if (i == index - 1) {
                            Node input = new Node();
                            input.data = obj;
                            input.next = pointer.next;
                            pointer.next = input;
                        } else {
                            pointer = pointer.next;
                        }
                    }
                }
            }
        } catch (
                PizzaException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Swaps the location of the given index with the node one index location
     * lower in the List
     * @param index an int for the index that you would like to swap down the
     *              List
     */
    protected void swap(int index){
        T temp1 = this.remove(index);
        T temp2 = this.remove(index - 1);
        this.insert(temp1, index - 1);
        this.insert(temp2, index);
    }

    /**
     * Pre: Takes in an int as an index location to be removed
     * Post: Checks that the index location is valid, if the location is
     * outside of the range of the index (less than 0 or greater than the
     * current size) an exception will be thrown and a message output. If the
     * index is valid, this method iterates to that location, removes the
     * desired Node and returns the stored Object.
     *
     * @param index an int between 0 and the current size of the linked list -1.
     * @return the object stored in the index location of the linked list.
     */
    public T remove(int index) {
        T output = null;
        try {
            if (!this.checkIndex(index)) {//checking for valid input
                if (head.next == null) {//removes head object and sets List
                    // to default.
                    output = head.data;
                    head = null;
                } else if (index == 0) {//removes object stored in head and
                    // sets object at index 1 as the new head
                    output = this.head.data;
                    this.head = head.next;
                    return output;
                } else {//iterates through the linked list to the index
                    // location, removes and returns the Object at the
                    // requested index.
                    Node pointer = head;
                    Node pointer2 = head;//2nd pointer keeps track of the
                    // node 1 index before the one to be removed.
                    for (int i = 0; i <= index; i++) {
                        if (i == index) {
                            output = pointer.data;
                            pointer2.next = pointer.next;
                        } else if (i == index - 1) {
                            pointer2 = pointer;
                            pointer = pointer.next;
                        } else {
                            pointer = pointer.next;
                        }
                    }
                }
            }
        } catch (PizzaException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return output;
    }

    /**
     * Internal helper method used to validate the input index against the
     * current linked list object.
     *
     * @param index passed from calling method
     * @return false if there were no issues with the index
     * @throws PizzaException this exception is handled by the calling
     *                             methods of this class
     */
    private boolean checkIndex(int index) throws PizzaException {

        if (index > this.size() || index < 0) {
            if (this.size() == 0) {
                throw new PizzaException("This " + getClass().getName() +
                        " is empty");
            } else {
                throw new PizzaException("Outside of " + getClass()
                        .getName() + " range.");
            }
        }
        return false;
    }

    /**
     * Pre: takes in an int as an index location to be deleted from the
     * linked list.
     * Post: Calls the remove method to remove the desired index, does not
     * return the object.
     *
     * @param index an int between 0 and this.size()-1.
     */
    public void delete(int index) {
        this.remove(index);
    }

    /**
     * Pre: Takes in an object to be added to the end of the linked list
     * Post: Calls this class' insert method with this.size() as the index
     * location.
     * @param next an object of any type to be placed at the end of the
     *             linked list.
     */
    public void append(T next) {
        this.insert(next, this.size());
    }

    /**
     * Pre: none
     * Post: Iterates through the linked list and prints each stored Object
     * on the list on its own line along with the index where each object was
     * found.
     * @return a String with each stored object and the index location of the
     * objects.
     */
    @Override
    public String toString() {
        String output = "";
        Node pointer = head;
        for (int i = 0; i < this.size(); i++) {//iterating through each Node
            output += this.getClass().getName() + " location " + i + " " +
                    "contains: " + pointer.data.toString() + '\n';
            pointer = pointer.next;
        }
        return output;
    }

    /**
     * Pre: none
     * Post:checks the size of the linked list to see if it is 0 or not
     * @return if the size is 0, returns true. Otherwise returns false.
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Pre: Takes in an Object of any type that you want to search for
     * Post: Ensures that the passed in Object is not null, returns an
     * exception if it is null. Iterates through the linked list and calls
     * the equals method on each Object to compare it to the target. Collects
     * the index location of the first instance of the target object in the
     * linked list and returns that location.
     * @param target any non-null object you would like to search for
     * @return the index location of the first instance of the target Object
     * or -1 if the Object was not found.
     */
    public int indexOf(T target) {
        int index = -1;
        Node pointer = head;
        try {
            if (target == null) {
                throw new PizzaException("Cannot search for null memory" +
                        " locations. Please try again with a real object.");
            }
            for (int i = 0; i < this.size(); i++) {//iterates through the
                // linked list calling the equals method on each stored Object
                if (pointer.data.equals(target)) {
                    index = i;
                    i = this.size();//used to terminate loop once the target
                    // is located
                } else {
                    pointer = pointer.next;
                }
            }
        } catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
        return index;
    }

    /**
     * Pre: Takes in an Object of any type
     * Post: Compares the input Object against this object to determine if
     * they are the same. They are considered the same if they are of the
     * same class name, have the same size, and have the same stored data in
     * each location.
     * @param obj an Object of any type that you want to compare to the
     *            stored Object
     * @return a boolean true if the input Object is the same as the stored
     * Object or false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        boolean checkVal = false;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            List check = (List) obj;
            if (check.size() != this.size()) {
                return false;
            } else if (check.head == null && this.head == null) {
                return true;
            } else if (check.head == null) {
                return false;
            } else {
                Node pointer1 = this.head;
                Node pointer2 = check.head;
                if (pointer1.data.equals(pointer2.data) && pointer1.next ==
                        null) {
                    return true;
                } else {
                    while (pointer1.next != null) {
                        if (pointer1.data.equals(pointer2.data)) {
                            checkVal = true;
                        } else {
                            return false;
                        }
                    }
                }
            }

        }
        return checkVal;
    }
}


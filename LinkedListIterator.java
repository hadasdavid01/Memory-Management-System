/*

           Assignment number :9
           File Name : LinkedListIerator.java
           Name: Hadas David
           Student ID : 207643487
           Email : Hadasd105@gmail.com

       */
/** Represents an iterator of a linked list. */
public class LinkedListIterator<T> {

    // current position in the list (cursor)
    private Node<T> current;

    /** Constructs a list iterator, starting at the given node */
    public LinkedListIterator(Node<T> node) {
        current = node;
    }

    /** Checks if this iterator has more nodes to process */
    public boolean hasNext() {
        return (current != null);
    }

    /** Returns the current element in the list, and advances the cursor */
    public T next() {
        Node<T> currentNode = current;
        current = current.next;
        return currentNode.data;
    }
}
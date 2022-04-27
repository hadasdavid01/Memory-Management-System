/*

           Assignment number :9
           File Name : LinkedList.java
           Name: Hadas David
           Student ID : 207643487
           Email : Hadasd105@gmail.com

       */
/**
 * Represents a list of Nodes.
 */
public class LinkedList<T> {

    private Node<T> first = null; // pointer to the first (dummy) node of this list
    private Node<T> last = null;  //  pointer to the last node of this list
    private int size = 0;         // number of elements in this list */

    /**
     * Constructs a new list.
     */
    public LinkedList() {
        this.first = new Node<T>(null);
        this.last = first;
        this.size = 0;
    }

    /**
     * Creates a new Node object that points to the given object,
     * and inserts the node at the given index in this list.
     * <p>
     * If the given index is 0, the new node becomes the first node in this list.
     * <p>
     * If the given index equals the list's size, the new node becomes the last
     * node in this list.
     *
     * @param insert the object to be inserted into the list
     * @param index  the index before which the object should be inserted
     * @throws IllegalArgumentException if index is negative or greater than the list's size
     */
    public void add(int index, T insert) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            addFirst(insert);
            return;
        }
        if (size == index){
        	addLast(insert);
        	return;
		}

		Node<T> newNode = new Node<T>(insert);
        Node<T> iter = this.first.next;
        for(int i = 0; i < index-1; i++){
			iter = iter.next;
		}
        newNode.next = iter.next;
		iter.next = newNode;
		this.size++;
    }


    /**
     * Creates a new node with a reference to the given object, and appends it
     * to the end of this list(the node will become the list's last node).
     * The running time of this method must be O(1).
     *
     * @param insert the given object
     */
    public void addLast(T insert) {
        Node<T> newNode = new Node<T>(insert);
        if (size == 0) {
            this.first.next = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.last.next;
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * Creates a new node with a reference to the given object, and inserts it
     * at the beginning of this list (the node will become the list's first node).
     * The running time of this method must be O(1).
     *
     * @param insert
     * the given object
     */

    public void addFirst(T insert) {
        Node<T> newNode = new Node<T>(insert);
        newNode.next = this.first.next;
        this.first.next = newNode;
        if (this.last == null) {
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * Gets the object located at the given index in this list.
     *
     * @param index the index of the retrieved object
     * @return the object at the given index
     * @throws IllegalArgumentException if index is negative or greater than or equal to size
     */
    public T get(int index) {
		Node<T> iter = this.first.next;
        if(index < 0 || index >= size){
        	throw new IllegalArgumentException();
		}
        for(int i = 0; i < index; i++){
        	iter = iter.next;
			}
        return iter.data;
    }

    /**
     * Gets the index of the node pointing to the given object.
     *
     * @param t the given object
     * @return the index of the first occurrence of the object, or -1 if the object is not in this list
     */
    public int indexOf(T t) {
		Node<T> iter = this.first.next;
		for (int i = 0; i < size; i++){
			if (t.equals(iter.data)){
				return i;
			}
			iter = iter.next;
		}
        return -1;
    }


    /**
     * Removes from this list the first occurrence of a node pointing to the given object.
     *
     * @param remove the object that should be removed from the list
     * @throws IllegalArgumentException if the given memory block is not in this list
     */
    public void remove(T remove) {
		Node<T> iter = this.first;
		Node<T> iter2 = this.first.next;
		while (iter2 != null){
			if (remove.equals(iter2.data)){
				iter.next = iter2.next;
				this.size--;
				return;
			}
			iter = iter.next;
			iter2 = iter2.next;
		}
		throw new IllegalArgumentException();
    }

    /**
     * Returns an iterator over this list, starting with the first element.
     */
    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<T>(first.next);
    }

    /**
     * A textual representation of this list, useful for debugging.
     */
    public String toString() {
        String str = "";
		LinkedListIterator<T> iter = this.iterator();
        for (int i = 0; i < size; i++){
        	str += iter.next();
		}
        return str;
    }
}
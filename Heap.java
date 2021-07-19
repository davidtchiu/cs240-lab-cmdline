import java.util.NoSuchElementException;

/**
 * Class implementation of a min-heap: the children of each
 * node must be greater than their parent.
 *
 * @author David
 * @version 03/21/18
 */
public class Heap<E extends Comparable<E>> {
    private final int INITIAL_CAPACITY = 10;
    private E[] the_data;
    private int capacity;
    private int size;

    /**
     * Creates an empty heap of default capacity of 10
     */
    public Heap() {
        capacity = INITIAL_CAPACITY;
        size = 0;
        the_data = (E[]) new Comparable[capacity];
    }

    /**
     * @return the item located at the given index
     */
    public E get(int index) {
        return the_data[index];
    }

    /**
     * Adds an item to the heap
     * @param item The element to add to the heap
     */
    public void add(E item) {
        // out of space; double capacity
        if (size == capacity) {
            reallocate();
        }

        the_data[size] = item;
        percolateUp(size);
        size++;
    }

    /**
     * Compares the item located in the given index with its parent
     * and possibly move it up the heap by swapping with its parent.
     * 
     * @param i index of the item to percolate up
     */
    private void percolateUp(int i) {
        // only attempt to percolate up if current node is not root
        if (i > 0) {
            // Compare with parent
            int parent = (i-1)/2;
            if (the_data[i].compareTo(the_data[parent]) < 0) {
                E tmp = the_data[i];
                the_data[i] = the_data[parent];
                the_data[parent] = tmp;

                // recursively percolate parent node up
                percolateUp(parent);
            }
        }
    }

    /**
     * Removes the item at the specified index
     * 
     * @param index the position of the node to remove 
     * @return the deleted item
     * @throws NoSuchElementException if the heap is empty
     */
    public E remove(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        E tmp = the_data[index];            // save it for returning
        the_data[index] = the_data[size-1]; // replace the node with the last node (which is larger)
        size--;
        percolateDown(index);   // percolate the replaced (larger) node down
        return tmp;
    }

    /**
     * Compares the item located in the given index with its children,
     * and possibly move it down the heap by swapping with 
     * one of its children.
     * 
     * @param i index of the item to percolate down
     */
    private void percolateDown(int i) {
        int left = 2*i + 1;    // left index
        int right = 2*i + 2;   // right index

        // find the smaller child
        int smallest;

        // left child doesn't exist (right must also not exist)
        if (left >= size) {
            return;  // no item to swap with, so terminate
        }
        // right node doesn't exist; left node is the only swap candidate
        else if (right >= size) {
            smallest = left;
        }
        // both children exist, find the smaller one
        else {
            if (the_data[right].compareTo(the_data[left]) >= 0) {
                smallest = left;
            }
            else {
                smallest = right;
            }
        }

        // swap if child is actually smaller
        if (the_data[i].compareTo(the_data[smallest]) > 0) {
            E tmp = the_data[i];
            the_data[i] = the_data[smallest];
            the_data[smallest] = tmp;

            // recursively percolate down from the smaller node
            percolateDown(smallest);
        }
    }      

    /**
     * Doubles the capacity of the current list
     */
    private void reallocate() {
        //instantiate a new list that's double the capacity
        E[] new_data = (E[]) new Comparable[capacity * 2];

        //copy over current data elements
        for (int i = 0; i < capacity; i++) {
            new_data[i] = the_data[i];
        }

        //update capacity
        capacity *= 2;

        //update the_data to reference new list
        the_data = new_data;
    }

    /**
     * @return current size of the heap
     */
    public int size() {
        return size;
    }

    /**
     * @return string representation of the heap (tree version)
     */
    @Override
    public String toString() {
        return toStringHelper(0, 0);
    }

    private String toStringHelper(int i, int level) {
        String str = "";
        for (int l = 0; l < level; l++) {
            str += "  ";
        }
        if (i >= size) {
            str += "null\n";
        }
        else {        
            str += the_data[i] + "\n";              // data
            str += toStringHelper(i*2+1, level+1);  // concatenate left subtree
            str += toStringHelper(i*2+2, level+1);  // concatenate right subtree
        }
        return str;
    }

    /**
     * @return the string representation (list version)
     */
    public String toStringList() {
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += the_data[i];
            //add a comma if not the last element
            if (i < size-1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
}

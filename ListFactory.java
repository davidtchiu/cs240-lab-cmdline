import java.util.*;

/**
 * This class provides lists of ints
 *
 * @author David
 * @version 3/29/18
 */
public class ListFactory {
    private static Random rng = new Random();
    private static final int UPPER_BOUND = 1000;   /** upper bound of numbers 
                                                        appearing in list */
    private int[] list;

    /**
     * Produces a list of integers
     * @param size the length of the list
     * @return a list of the specified size
     */
    public static int[] getList(int size) {
        if (size <= 0) {
            //illegal size entered. Default to size 100 array
            size = 100;
            throw new IllegalArgumentException("Illegal list size entered: " + size);
        }

        //fill the array with random numbers from 0 to size-1
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = rng.nextInt(UPPER_BOUND);
        }

        //shuffle the array so that numbers are shuffled in random places
        shuffle(list);
        return list;
    }

    /**
     * Prints the contents in the list.
     * @param list an integer array
     */
    public static void print(int[] list) {
        StringBuilder str = new StringBuilder();
        if (list.length > 0) {
            for (int i=0; i<list.length-1; i++) {
                str.append(list[i] + ", ");
            }
            str.append(list[list.length-1]);
        }
        System.out.println("[" + str.toString() + "]");
    }
    
    /**
     * Shuffles the items around in the given array
     * @param list  an integer array
     */
    public static void shuffle(int[] list) {
        for (int i = 0; i < list.length; i++) {
            //generate a random index from i to list.length-1
            int randIdx = rng.nextInt(list.length-i) + i;

            //swap current element with another element in the list
            int tmp = list[i];
            list[i] = list[randIdx];
            list[randIdx] = tmp;
        }
    }
}
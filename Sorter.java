import java.util.Random;
import java.util.Arrays;

/**
 * A class with classic sorting algorithms.
 * 
 * @author David
 * @version 2/8/2018
 */
public class Sorter {
    /**
     * Insertion Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] insertionSort(int[] list) {                
        for (int i = 1; i < list.length; i++) {
            int toBeInserted = list[i];

            // Need to find the place to put toBeInserted
            int j = i-1;
            while (j >= 0 && toBeInserted < list[j]) {
                // Shift items to the right to make space for it
                list[j+1] = list[j];
                j--;
            }
            // Found the place where it should go!
            list[j+1] = toBeInserted;
        }
        return list;
    }

    /**
     * Selection Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] selectionSort(int[] list) {
        //i is the index of the first element of the unsorted sublist
        for (int i = 0; i < list.length; i++) {
            int minIdx = i; //index of minimum element found so far in unsorted sublist
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < list[minIdx]) {
                    //found a smaller element at list[j], so update minIdx to j
                    minIdx = j;
                }
            }
            swap(list, i, minIdx);
        }
        return list;
    }

    /**
     * Bubble Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] bubbleSort(int[] list) {
        boolean swapped = true; //lets us short-circuit the loop if no swaps were made
        for (int i = 0; swapped && i < list.length; i++) {
            swapped = false;
            for (int j = 1; j < list.length - i; j++) {
                if (list[j-1] > list[j]) {
                    //swap the two elements (bubble larger one up)
                    swap(list, j-1, j);

                    //indicate that a swap was made
                    swapped = true;
                }
            }
        }
        return list;
    }

    /**
     * Bubble Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] shakerSort(int[] list) {
        boolean swapped = true; //lets us short-circuit the loop if no swaps were made
        for (int i = 0; swapped && i < list.length; i++) {
            swapped = false;
            if (i % 2 == 0) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j-1] > list[j]) {
                    //swap the two elements (bubble larger one up)
                    swap(list, j-1, j);

                    //indicate that a swap was made
                    swapped = true;
                }
            }
        } else {
            for (int j = list.length - i -1; j > i; j--) {
                if (list[j-1] > list[j]) {
                    //swap the two elements (bubble larger one up)
                    swap(list, j-1, j);

                    //indicate that a swap was made
                    swapped = true;
                }
            }
        }
        }
        return list;
    }
    
    
    /**
     * Odd-Even Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] oddEvenSort(int[] list) {
        boolean swapped = true; //lets us short-circuit the loop if no swaps were made
        for (int i = 0; swapped && i < list.length; i++) {
            swapped = false;
            if (i % 2 == 0) { // even pass
                for (int j = 0; j < list.length - 1; j += 2) {
                    if (list[j] > list[j+1]) {
                        swap(list, j, j+1);
                        swapped = true;
                    }
                }
            }
            else {  // odd pass
                for (int j = 1; j < list.length - 1; j += 2) {
                    if (list[j] > list[j+1]) {
                        swap(list, j, j+1);
                        swapped = true;                        
                    }
                }
            }
        }
        return list;
    }

    /**
     * HeapSort, an O(n log n) sorting algorithm!
     * 
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] heapSort(int[] list) {
        Heap<Integer> heap = new Heap<>();

        // build heap -- add all items from the list
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // re-build the list by continuously pulling 
        // the min from the heap
        for (int i = 0; i < list.length; i++) {
            list[i] = heap.remove(0);
        }

        return list;
    }

    /**
     * Merge Sort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] mergeSort(int[] list) {
        // base case: list is sorted when empty or contains one item
        if (list.length <= 1) {
            return list;
        }

        int mid = list.length/2;

        // first half of list
        int[] first = Arrays.copyOfRange(list, 0, mid);
        first = mergeSort(first);   // sort it

        // second half of list
        int[] second = Arrays.copyOfRange(list, mid, list.length);
        second = mergeSort(second); // sort it

        // merge the sorted lists
        return merge(first, second);
    }

    /**
     * Merges two pre-sorted lists into a sorted list
     * @param first     A sorted list
     * @param second    Another sorted list
     * @return a sorted list containing elements from both input lists
     */
    private static int[] merge(int[] first, int[] second) {
        // merge the two pre-sorted lists
        int[] mergedList = new int[first.length+second.length];
        int i = 0, j = 0, k = 0; 
        while (j < first.length && k < second.length) {
            if (first[j] < second[k]) {
                mergedList[i++] = first[j++];
            }
            else {
                mergedList[i++] = second[k++];
            }
        }

        // finish off any stragglers from first list
        while (j < first.length) {
            mergedList[i++] = first[j++];
        }

        // finish off any stragglers from second list
        while (k < second.length) {
            mergedList[i++] = second[k++];
        }
        return mergedList;
    }

    /**
     * QuickSort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    public static int[] quickSort(int[] list) {
        return quickSort(list, 0, list.length-1);
    }

    /**
     * QuickSort
     * @param list  A list of ints
     * @return a sorted list of ints
     */
    private static int[] quickSort(int[] list, int start, int end) {
        if (start < end) {
            // partitions the list, and gets the position of the pivot
            int pivot_idx = partition(list, start, end);
            
            // sort the two other halves
            quickSort(list, start, pivot_idx-1);
            quickSort(list, pivot_idx+1, end);
        }
        return list;
    }

    /**
     * Partition
     * @param list  A list of ints
     * @param start The start position
     * @param end   The end position
     * @return The pivot's position in the list
     */
    private static int partition(int[] list, int start, int end) {
        int pivot = list[end];  // use last item in the sublist as pivot
        int i = start;
        for (int j = start; j < end; j++) {
            if (list[j] < pivot) {
                swap(list, i, j);
                i++;
            }
        }
        // swap pivot into proper position
        swap(list, i, end);
        return i;
     }    
    
    /**
     * Swaps two items, indexed by i and j in the given list
     */
    private static void swap(int[] list, int i, int j) {
        int tmp = list[i]; 
        list[i] = list[j];
        list[j] = tmp;
    }

    /**
     * @return true if the given list is in ascending order, false otherwise
     */
    public static boolean inOrder(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i-1] > list[i]) {
                return false;
            }
        }
        return true;
    }    
}
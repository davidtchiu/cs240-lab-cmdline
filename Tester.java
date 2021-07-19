public class Tester {
    private static final int LIST_SIZE = 10000;
    private static final boolean HEAP_SORT = false;
    private static final boolean MERGE_SORT = false;
    private static final boolean QUICK_SORT = false;
    private static final boolean INSERTION_SORT = false;
    private static final boolean BUBBLE_SORT = false;
    private static final boolean SHAKER_SORT = true;
    private static final boolean ODDEVEN_SORT = false;
    private static final boolean SELECTION_SORT = false;

    public static void main(String[] args) {
        int[] list = ListFactory.getList(LIST_SIZE);
        long startTime, endTime;

        /** Run Merge Sort */
        if (MERGE_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.mergeSort(list);
            endTime = System.nanoTime();
            System.out.println("Merge sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Heap Sort */
        if (HEAP_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.heapSort(list);
            endTime = System.nanoTime();
            System.out.println("Heap sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Quick Sort */
        if (QUICK_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.quickSort(list);
            endTime = System.nanoTime();
            System.out.println("Quick sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Insertion Sort */
        if (INSERTION_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.insertionSort(list);
            endTime = System.nanoTime();
            System.out.println("Insertion sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Odd-Even Sort */
        if (ODDEVEN_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.oddEvenSort(list);
            endTime = System.nanoTime();
            System.out.println("Odd-Even sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Bubble Sort */
        if (BUBBLE_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.bubbleSort(list);
            endTime = System.nanoTime();
            System.out.println("Bubble sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Bubble Sort */
        if (SHAKER_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.shakerSort(list);
            endTime = System.nanoTime();
            System.out.println("Shaker sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        /** Run Selection Sort */
        if (SELECTION_SORT) {
            ListFactory.shuffle(list);
            startTime = System.nanoTime();
            list = Sorter.selectionSort(list);
            endTime = System.nanoTime();
            System.out.println("Selection sort took: " + (endTime - startTime)/1000000.0 + "ms");
            System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        }

        // ListFactory.shuffle(list);
        // startTime = System.nanoTime();
        // try {
        // //ListFactory.print(list);
        // list = FastOddEvenSorter.oddEvenSort(list);
        // endTime = System.nanoTime();
        // System.out.println("FastOddEven sort took: " + (endTime - startTime)/1000000.0 + "ms");
        // System.out.println("Sorted? " + Sorter.inOrder(list) + "\n");
        // //ListFactory.print(list);
        // } catch(InterruptedException e) {
        // e.printStackTrace();
        // }        
    }
}

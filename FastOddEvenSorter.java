import java.lang.Runnable;

/**
 * Parallelized Odd-Even Sort
 *
 * @author David
 * @version 4/21/2018
 */

public class FastOddEvenSorter
{
    private static final int NUM_THREADS = 4;

    public static int[] oddEvenSort(int[] list) throws InterruptedException {
        Thread[] t = new Thread[2*NUM_THREADS];
        int mid = list.length/NUM_THREADS;
        for (int i = 0; i < list.length; i++) {
            t[0] = new Thread(new FastOddEvenWorker(list, 0, mid - 1));
            t[1] = new Thread(new FastOddEvenWorker(list, mid - 1, 2*mid - 1));
            t[2] = new Thread(new FastOddEvenWorker(list, 2*mid - 1, 3*mid - 1));
            t[3] = new Thread(new FastOddEvenWorker(list, 3*mid - 1, list.length - 1));
            t[4] = new Thread(new FastOddEvenWorker(list, 1, mid - 1));
            t[5] = new Thread(new FastOddEvenWorker(list, mid, 2*mid - 1));
            t[6] = new Thread(new FastOddEvenWorker(list, 2*mid, 3*mid - 1));
            t[7] = new Thread(new FastOddEvenWorker(list, 3*mid, list.length - 1));
            if (i % 2 == 0) { // even pass
                //t[0] = new Thread(new FastOddEvenWorker(list, 0, mid - 1));
                //t[1] = new Thread(new FastOddEvenWorker(list, mid - 1, list.length - 1));
                t[0].start();
                t[1].start();
                t[2].start();
                t[3].start();
                t[0].join();
                t[1].join();
                t[2].join();
                t[3].join();
            }
            else {  // odd pass
                // t[0] = new Thread(new FastOddEvenWorker(list, 1, mid - 1));
                // t[1] = new Thread(new FastOddEvenWorker(list, mid, list.length - 1));
                t[4].start();
                t[5].start();
                t[6].start();
                t[7].start();
                t[4].join();
                t[5].join();
                t[6].join();
                t[7].join();
            }
        }

        return list;
    }

    private static class FastOddEvenWorker implements Runnable {
        private int[] list;
        private int start;
        private int end;

        public FastOddEvenWorker(int[] list, int start, int end) {
            this.list = list;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int j = start; j < end; j += 2) {
                if (list[j] > list[j+1]) {
                    int tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                }
            }
        }
    }
}

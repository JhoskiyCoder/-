import java.util.concurrent.TimeUnit;

public class Main {
    static long last = 42;
    static final long a = 25214903917L; // Multiplier
    static final long c = 11; // Increment
    static final long m = 1L << 48; // Modulus

    static int nextInt(int bound) {
        last = (a * last + c) % m;
        return (int) (last % bound);
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        final int N = 100;
        int[] arr = new int[N];

        final int M = 50;
        long[] sortingTimes = new long[M];

        long start = System.nanoTime();

        // Save initial value of last
        long initialLast = last;

        for (int i = 1; i <= M; i++) {
            // Restore initial value of last
            last = initialLast;

            for (int j = 0; j < N; j++) {
                arr[j] = nextInt(1007);
            }

            long sortStart = System.nanoTime();

            // Sorting algorithm
            insertionSort(arr);

            long sortStop = System.nanoTime();
            long sortDuration = sortStop - sortStart;

            // Add value of time in array in nanoseconds
            sortingTimes[i - 1] = sortDuration;
        }

        // Average time in nanoseconds
        long averageTime = 0;
        for (int i = 0; i < M; i++) {
            averageTime += sortingTimes[i];
        }
        System.out.println("Average Time: " + (double) averageTime / M + " nanoseconds");
    }
}
import java.util.Random;


public class Main {

    private static long last = 42; // seed
    private static final long a = 25214903917L; // Multiplier
    private static final long c = 11; // Increment
    private static final long m = (long) Math.pow(2, 48); // Modulus


    public static int nextInt(int bound) {
        last = (a * last + c) % m;
        return (int) (last % bound);
    }


  private static void fillArray(int[] arr) {
        Random random = new Random();

        random.setSeed(42);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nextInt(1007);
        }

   }

    public static void main(String[] args) {
      
        int N = 10_000;

        int[] arr = new int[N];

        fillArray(arr);


        for(int i = N - 30; i < N; i++) System.out.print(arr[i] + " ");


    /*
        System.out.println("Исходный массив:");
        printArray(arr);
    */

        long startTime = System.nanoTime(); // время начала выполнения

        insertionSort(arr); // сортировка вставками

        long endTime = System.nanoTime(); // время окончания выполнения

    /**
        System.out.println("\nОтсортированный массив:");
        printArray(arr);
    */

        long durationMilliseconds = (endTime - startTime) / 1_000_000; // время выполнения в миллисекундах
        long durationNanoseconds = (endTime - startTime) % 1_000_000; // время выполнения в наносекундах

        System.out.println("\nВремя выполнения: " + durationMilliseconds + " миллисекунд " + durationNanoseconds + " наносекунд");
    }

    public static void insertionSort(int[] arr) {
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

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

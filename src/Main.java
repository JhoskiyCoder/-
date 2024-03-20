import java.util.Random;


public class Main {
     private void fillArray(int[] arr, int N) {
        Random random = new Random();
        for(int i = 0; i < N; i++) {
            arr[i] = random.nextInt(1001);
        }
         
     }
    
    public static void main(String[] args) {
        int N = 10_000;
        int[] arr = new int[N];

        System.out.println("Исходный массив:");
        printArray(arr);

        long startTime = System.nanoTime(); // время начала выполнения

        insertionSort(arr); // сортировка вставками

        long endTime = System.nanoTime(); // время окончания выполнения

        System.out.println("\nОтсортированный массив:");
        printArray(arr);

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

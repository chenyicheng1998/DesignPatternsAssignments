import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {
    public static void main(String[] args) {
        // create sorting strategies
        SortingStrategy[] strategies = {
            new BubbleSortStrategy(),
            new QuickSortStrategy(),
            new MergeSortStrategy()
        };

        // test with small array (30 elements)
        System.out.println("=== Small Array Test (30 elements) ===\n");
        int[] smallArray = generateRandomArray(30);
        testAllStrategies(strategies, smallArray);

        System.out.println("\n===========================================\n");

        // test with large array (100,000 elements)
        System.out.println("=== Large Array Test (100,000 elements) ===\n");
        int[] largeArray = generateRandomArray(100000);
        testAllStrategies(strategies, largeArray);
    }

    private static void testAllStrategies(SortingStrategy[] strategies, int[] originalArray) {
        SortingContext context = new SortingContext(strategies[0]);

        for (SortingStrategy strategy : strategies) {
            context.setStrategy(strategy);

            // create a copy of the array for each strategy
            int[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);

            // show first 10 elements before sorting (only for small arrays)
            if (originalArray.length <= 30) {
                System.out.println("Original array: " + Arrays.toString(arrayCopy));
            } else {
                System.out.println("Array size: " + arrayCopy.length + " elements");
            }

            // measure time
            long startTime = System.nanoTime();
            context.sort(arrayCopy);
            long endTime = System.nanoTime();

            long durationNano = endTime - startTime;
            double durationMilli = durationNano / 1_000_000.0;

            // show first 10 elements after sorting (only for small arrays)
            if (originalArray.length <= 30) {
                System.out.println("Sorted array:   " + Arrays.toString(arrayCopy));
            }

            System.out.println("Algorithm: " + context.getStrategyName());
            System.out.println("Time taken: " + durationMilli + " ms");
            System.out.println("Time taken: " + durationNano + " nanoseconds");

            // verify the array is sorted
            if (isSorted(arrayCopy)) {
                System.out.println("Status: Successfully sorted!");
            } else {
                System.out.println("Status: ERROR - Array not sorted correctly!");
            }

            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


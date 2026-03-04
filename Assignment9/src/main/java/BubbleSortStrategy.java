// Reference: https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
// Source code adapted from GeeksforGeeks - Optimized Bubble Sort implementation
// Bubble Sort Algorithm - repeatedly swaps adjacent elements if they are in wrong order
public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}


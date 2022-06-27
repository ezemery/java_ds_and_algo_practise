package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] sort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortHelper(int[] array, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;

        int pivotIndex = startIndex;
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;

        while(leftIndex <= rightIndex){
            if(array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]){
                swap(array, leftIndex, rightIndex);
            }

            if(array[leftIndex] <= array[pivotIndex]){
                leftIndex++;
            }
            if(array[rightIndex] >= array[pivotIndex]){
                rightIndex--;
            }
        }

        swap(array, pivotIndex, rightIndex);

        // Improve the space complexity by sorting the smaller array first
        boolean isLeftSmaller = rightIndex - 1 - startIndex < endIndex - (rightIndex + 1);
        if(isLeftSmaller){
            quickSortHelper(array, startIndex, rightIndex - 1);
            quickSortHelper(array, rightIndex + 1, endIndex);
        }else{
            quickSortHelper(array, rightIndex + 1, endIndex);
            quickSortHelper(array, startIndex, rightIndex - 1);

        }

    }

    public static void swap(int[] array, int one, int two){
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    public static void main(String[] args) {
        try {
            doTestsPass();
            System.out.println("All tests passed");
        } catch (Exception ex) {
            System.out.println("Test failed");
            ex.printStackTrace();
        }
    }

    private static void doTestsPass() throws Exception {

        int[] unsorted = new int[]{  8, 5, 2, 9, 5, 6, 3};
        int[] sorted = new int[]{2, 3, 5, 5, 6, 8, 9};
        int[] sort = sort(unsorted);
        assertTrue(Arrays.equals(sorted, sort), Arrays.toString(sort)+" is not equal to: " + Arrays.toString(sorted));

    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}

package Sorting;

import PriorityQueue.Solution;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
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

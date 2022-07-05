package Sorting;

import java.util.Arrays;

public class HeapSort {

    public static int[] sort(int[] array){
        buildMaxheap(array);

        for(int endInx = array.length - 1; endInx > 0; endInx--){
            System.out.println("array "+ Arrays.toString(array) );
            swap(0, endInx, array);
            System.out.println("array "+ Arrays.toString(array) );
            reshuffleHeap(0,endInx - 1, array);
        }
        return array;
    }

    public static void buildMaxheap(int[] array){
        int firstParent = (array.length - 1)/2;
        for(int currIndx = firstParent; currIndx >= 0; currIndx--){
            reshuffleHeap(currIndx, array.length - 1, array);
       }

    }

    public static void reshuffleHeap(int i, int length, int[] array){
        int left = (2 * i) + 1;
        while(left <= length){
            int right = (2 * i) + 2 <= length ? (2 * i) + 2 : -1;
            int swapId;
            if(right != -1 && array[right] > array[left]){
                swapId = right;
            }else {
                swapId = left;
            }
            if(array[i] < array[swapId] ){
                swap(i,swapId, array);
                i = swapId;
                left = (2 * i) + 1;
            }else{
                return;
            }

        }
    }

    public static void swap(int one, int two, int[] array){
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

        unsorted = new int[]{1,2,3};
        sorted = new int[]{1,2,3};
        sort = sort(unsorted);
        assertTrue(Arrays.equals(sorted, sort), Arrays.toString(sort)+" is not equal to: " + Arrays.toString(sorted));

    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}

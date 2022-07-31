package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {3, -1, 4, 5, 5};
        int len = arr.length;
        int index = 0;
        List<Integer> res = new ArrayList<>();
        while(index < len){
            int correctIndex = arr[index] - 1;
            if(correctIndex > 0 && correctIndex < len  && arr[index] != arr[correctIndex]){
                swap(arr, index, correctIndex);
            }else{
                index++;
            }
        }

        for(int i = 0; i < len; i++){
           if(i != arr[i] - 1) {
               res.add(i + 1);
           }
        }
        System.out.println(Arrays.toString(arr)+" "+ res);
    }

    private static void swap(int[] arr, int first, int second) {

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

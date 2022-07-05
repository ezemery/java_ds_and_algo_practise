package PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class minHeap{
        boolean reverseOrder = false;
        List<Integer> list;


        public minHeap(){
            list = new ArrayList<>();
        }

        public void add(int value){
            list.add(value);
            int i = list.size() - 1;
            while(i > 1){
                int parent = (i-1)/2;
                if(list.get(i) < list.get(parent)){
                    int temp = list.get(i);
                    list.set(i, list.get(parent));
                    list.set(parent, temp);
                }
                i = (i-1)/2;
            }
        }

        public int remove(){
            int removedItem = list.get(0);
            int lastItem = list.get(list.size()-1);
            list.set(0, lastItem);
            list.remove(list.size()-1);
            int i = 0;

            while((2 * i) + 1 < list.size() && (2 * i) + 2 <  list.size()){
                int left = (2 * i) + 1;
                int right = (2 * i) + 2;

                if(list.get(left) < list.get(right)){
                    int temp = list.get(i);
                    list.set(i, list.get(left));
                    list.set(left, temp);
                    i = (2 * i) + 1;
                }else {
                    int temp = list.get(i);
                    list.set(i, list.get(right));
                    list.set(right, temp);
                    i = (2 * i) + 2;
                }
            }

            return removedItem;
        }

        public int  peek(){
            return list.get(0);
        }

        public String toString(){
            return list.toString();
        }
    }

    public static class maxHeap{
        List<Integer> list;


        public maxHeap(){
            list = new ArrayList<>();
        }

        public void add(int value){
            list.add(value);
            int i = list.size() - 1;
            while(i > 1){
                int parent = (i-1)/2;
                if(list.get(i) > list.get(parent)){
                    int temp = list.get(i);
                    list.set(i, list.get(parent));
                    list.set(parent, temp);
                }

                i = (i-1)/2;
            }
        }

        public int remove(){
            int removedItem = list.get(0);
            int lastItem = list.get(list.size()-1);
            list.set(0, lastItem);
            list.remove(list.size()-1);
            int i = 0;

            while((2 * i) + 1 < list.size() && (2 * i) + 2 <  list.size()){
                int left = (2 * i) + 1;
                int right = (2 * i) + 2;
                    if(list.get(left) > list.get(right)){
                        int temp = list.get(i);
                        list.set(i, list.get(left));
                        list.set(left, temp);
                        i = (2 * i) + 1;
                    }else {
                        int temp = list.get(i);
                        list.set(i, list.get(right));
                        list.set(right, temp);
                        i = (2 * i) + 2;
                    }
            }

            return removedItem;
        }

        public int  peek(){
            return list.get(0);
        }

        public String toString(){
            return list.toString();
        }
    }

    class PriorityQueue{

        public PriorityQueue(boolean reverseOrder){
            if(reverseOrder){
                new maxHeap();
            }else{
                new minHeap();
            }
        }
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

//        PriorityQueue queue = new PriorityQueue();
//
//        queue.add(3);
//        queue.add(4);
//        queue.add(0);
//        queue.add(2);
//        queue.remove();
//        queue.remove();
//        queue.add(1);
//        queue.add(5);
//        System.out.println(queue.peek());
//        System.out.println(queue.toString());

    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }

}

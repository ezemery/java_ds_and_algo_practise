package FenwickTree;
import java.util.*;

public class Solution {

    static class MyFenwickTree{

        public MyFenwickTree(int[] array){

        }

        public void add(int index, int value){

        }

        public int prefixSum(int i){

            return 0;
        }

        public int sum(int i, int j){

            return 0;
        }

        public int lsb(int i){
            return i & -i;
           // return Integer.lowestOneBit(i);
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6,7};
        MyFenwickTree tree = new MyFenwickTree(array);

        System.out.println(tree.lsb(3));

    }
}

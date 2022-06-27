package Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Implementing a set using a LinkedList Bucket
public class Solution {

    class Bucket{
        List<Integer> bucket;
        public Bucket(){
            bucket = new LinkedList<>();
        }
        public void add(int key) {
            if(bucket.contains(key)){
                return;
            }else{
                bucket.add(key);
            }
        }
        public void remove(int key) {
            // Iterator iterator = bucket.iterator();
            // while(iterator.hasNext()){
            //     Integer next = (Integer)iterator.next();
            //     if(next.equals(key)){
            //         bucket.remove(next);
            //         break;
            //     }
            // }
            for(Integer value : bucket){
                if(key == value){
                    bucket.remove(value);
                    break;
                }
            }
        }
        public boolean contains(int key) {
            for(Integer value : bucket){
                if(key == value){
                    return true;
                }
            }
            return false;
        }
    }


    int hashKey;
    List<Bucket> hashSet;
    public Solution() {
        hashKey = 2000;
        hashSet = new ArrayList<>();
        for(int i = 0; i <= hashKey; i++){
            hashSet.add(new Bucket());
        }
    }

    public void add(int key) {
        int hashValue = key % hashKey;
        hashSet.get(hashValue).add(key);
    }

    public void remove(int key) {
        int hashValue = key % hashKey;
        hashSet.get(hashValue).remove(key);

    }

    public boolean contains(int key) {
        int hashValue = key % hashKey;
        return hashSet.get(hashValue).contains(key);
    }
}

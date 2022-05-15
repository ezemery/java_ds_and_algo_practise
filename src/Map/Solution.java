package Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    class Bucket{
        List<Pair> bucket = new LinkedList<>();

        public void put(int key, int value) {
            boolean found = false;
            for(Pair pair : bucket){
                if(pair.first == key){
                    pair.second = value;
                    found = true;
                }
            }
            if(found == false){
                bucket.add(new Pair(key,value));
            }
        }

        public int get(int key) {
            for(Pair pair : bucket){
                if(pair.first == key){
                    return pair.second;
                }
            }

            return -1;
        }

        public void remove(int key) {
            for(Pair pair : bucket){
                if(pair.first == key){
                    bucket.remove(pair);
                    break;
                }
            }
        }
    }


    int hashKey;
    List<Bucket> hashMap;

    public Solution() {
        hashKey = 2000;
        hashMap = new ArrayList<>();
        for(int i = 0; i < hashKey; i++){
            hashMap.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashValue = key % hashKey;
        hashMap.get(hashValue).put(key, value);
    }

    public int get(int key) {
        int hashValue = key % hashKey;
        return hashMap.get(hashValue).get(key);
    }

    public void remove(int key) {
        int hashValue = key % hashKey;
        hashMap.get(hashValue).remove(key);
    }
}

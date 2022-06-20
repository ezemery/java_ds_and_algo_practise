package Queue;

public class Solution {
    //Implementing a queue using a circular array
    static class Queue {
        int[] queue;
        int head, capacity, size;
        public Queue(int k) {
            queue = new int[k];
            head = 0;
            capacity = k;
            size = 0;
        }

        public boolean enqueue(int value) {
            if(size < capacity){
                queue[(head + size) % capacity] = value;
                size++;
                return true;
            }else{
                return false;
            }

        }

        public boolean dequeue() {
            if(size > 0){
                queue[head] = -1;
                head = (head + 1) % capacity;
                size--;
                return true;
            }else{
                return false;
            }

        }

        public int Front() {
            if(size == 0) return -1;
            return queue[head];
        }

        public int Rear() {
            if(size == 0) return -1;
            return queue[(head + size -1) % capacity];

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
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

        final Queue queue = new Queue(3);
        // enqueue
    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}

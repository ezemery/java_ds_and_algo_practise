package Deque;

//Implementing a deque using a DoublyLinkedList
public class Solution {

    static class Node{
        String val;
        Node prev = null;
        Node next = null;
        public Node(String val){
            this.val = val;
        }
    }

    static class Deque {
        Node head;
        Node tail;
        int size;

        public Deque(){
            head = new Node(null);
            tail = new Node(null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(String data) {
            addAtIndex(0, data);
        }

        public void addLast(String data) {
            addAtIndex(size, data);
        }

        public void removeFirst() {
             deleteAtIndex(0);
        }

        public void removeLast() {
             deleteAtIndex(size - 1);
        }

        public String peekFirst() {
            return head.next.val;
        }

        public String peekLast() {
           return tail.prev.val;
        }

        public int size() {
            return size;
        }

        public void addAtIndex(int index, String val){
            Node toAdd = new Node(val);
            if(index > size) return;
            if(index < 0) index = 0;
            Node pred, succ;

            if(index <= size/2){
                pred = head;
                for(int i = 0; i < index; i++) pred = pred.next;
                succ = pred.next;
            }else{
                succ = tail;
                for(int i = 0; i < size - index; i++)  succ = succ.prev;
                pred = succ.prev;
            }
            pred.next = toAdd;
            toAdd.next = succ;
            succ.prev = toAdd;
            toAdd.prev = pred;
            size++;
        }

        public void deleteAtIndex(int index){
            Node pred, succ;
            if(index < size / 2){
                pred = head;
                for(int i = 0; i < index; i++) pred = pred.next;
                succ = pred.next;
            }else{
                succ = tail;
                for(int i = 0; i < size - index; i++) succ = succ.prev;
                pred = succ.prev;
            }

            pred.next = succ.next;
            succ.next.prev = pred;
            size--;

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

        final Deque deque = new Deque();

        deque.addLast("a");
        deque.addLast("b");

        assertTrue(deque.size() == 2, "Test failed, size should be 2");
        assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");
        assertTrue("b".equals(deque.peekLast()), "Last element should be 'b'");

        deque.addFirst("c");
        assertTrue("c".equals(deque.peekFirst()), "First element should be 'c'");
        deque.removeLast();
        assertTrue("a".equals(deque.peekLast()), "Last element should be 'a'");
        deque.removeFirst();
        assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");
        assertTrue(deque.size() == 1, "Test failed, size should be 1");
    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}
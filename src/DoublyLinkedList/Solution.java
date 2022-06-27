package DoublyLinkedList;



public class Solution {
    static class Node{
        int val;
        Node prev = null;
        Node next = null;
        public Node(int val){
            this.val = val;
        }

    }


    static class MyDoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public MyDoublyLinkedList(){
            head =  new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public int get(int index) {
            Node curr = head;
            if (index < 0 || index >= size) return -1;
            if (index < size / 2){
                for(int i = 0; i < index + 1; i++) curr = curr.next;
            }else {
                curr = tail;
                for(int i = 0; i < size - index; i++) curr = curr.prev;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public int peekFirst() {
            return head.next.val;
        }

        public int peekLast() {
            return tail.prev.val;
        }
        public void removeFirst() {
            deleteAtIndex(0);
        }

        public void removeLast() {
            deleteAtIndex(size - 1);
        }

        public void addAtIndex(int index, int val) {
            Node toAdd = new Node(val);
            if(index > size) return;
            if (index < 0) index = 0;
            Node pred, succ;
            if (index < size / 2) {
                pred = head;
                for(int i = 0; i < index; i++) pred = pred.next;
                succ = pred.next;
            }
            else {
                succ = tail;
                for (int i = 0; i < size - index; i++) succ = succ.prev;
                pred = succ.prev;
            }
            toAdd.next = succ;
            toAdd.prev = pred;
            pred.next = toAdd;
            succ.prev = toAdd;

            size++;

        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
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

        public int size(){
            return size;
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

        final MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtHead(2);

        assertTrue(doublyLinkedList.size() == 2, "Test failed, size should be 2");
        assertTrue(2 == doublyLinkedList.peekFirst(), "First element should be '2'");
        assertTrue(1 == doublyLinkedList.peekLast(), "Last element should be '1'");

        doublyLinkedList.addAtHead(3);
        assertTrue(3 == doublyLinkedList.peekFirst(), "First element should be '3'");
        doublyLinkedList.removeLast();
        assertTrue(2 == doublyLinkedList.peekLast(), "Last element should be '2'");
        doublyLinkedList.removeFirst();
        assertTrue(2 == doublyLinkedList.peekFirst(), "First element should be '2'");
        assertTrue(doublyLinkedList.size() == 1, "Test failed, size should be 1");
    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}

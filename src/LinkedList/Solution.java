package LinkedList;



public class Solution {
    static class Node{
        int val;
        Node prev = null;
        Node next = null;
        public Node(int val){
            this.val = val;
        }

    }


    static class MyLinkedList {

        Node head;
        int size;

        public MyLinkedList() {
         head = new Node(0);
         size = 0;
        }

        public int get(int index) {
            Node curr = head;
            if (index < 0 || index >= size) return -1;
            for(int i = 0; i < index + 1; i++) curr = curr.next;
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            Node toAdd = new Node(val);
            Node prev = head;
            if(index > size) return;
            if (index < 0) index = 0;
            for(int i = 0; i < index; i++) prev = prev.next;
            toAdd.next = prev.next;
            prev.next = toAdd;
            size++;
        }

        public void deleteAtIndex(int index) {
            Node prev = head;
            if (index < 0 || index >= size) return;
            for(int i = 0; i < index; i++) prev = prev.next;
            prev.next = prev.next.next;
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

        final MyLinkedList linkedList = new MyLinkedList();
    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}

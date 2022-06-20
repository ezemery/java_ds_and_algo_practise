package Deque;

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
        Node head = null;
        Node tail = null;
        public void addFirst(String data) {
            Node oldHead = head;
            Node newNode = new Node(data);
            oldHead.next = newNode;
            newNode.prev = oldHead;
            oldHead = newNode;

            // Node temp = head;
            // temp.next = new Node(data);
            // temp.next.prev = temp;
        }

        public void addLast(String data) {
            Node oldTail = tail;
            Node newNode = new Node(data);
            oldTail.next = newNode;
            newNode.prev = oldTail;
            oldTail = newNode;
        }

        public String removeFirst() {

            return "";
            //throw new RuntimeException("method not implemented");
        }

        public String removeLast() {
            throw new RuntimeException("method not implemented");
        }

        public String peekFirst() {
            throw new RuntimeException("method not implemented");
        }

        public String peekLast() {
            throw new RuntimeException("method not implemented");
        }

        public int size() {
            throw new RuntimeException("method not implemented");
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

        // enqueue
        deque.addLast("a");
        deque.addLast("b");

        assertTrue(deque.size() == 2, "Test failed, size should be 2");
        assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");
        assertTrue("b".equals(deque.peekLast()), "First element should be 'b'");

        //TODO: add your test cases here
        deque.addFirst("c");
        assertTrue("c".equals(deque.peekFirst()), "First element should be 'c'");
        assertTrue("b".equals(deque.removeLast()), "First element should be 'b'");
        assertTrue("a".equals(deque.peekLast()), "First element should be 'a'");
        assertTrue("c".equals(deque.removeFirst()), "First element should be 'c'");
        assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");
        assertTrue(deque.size() == 1, "Test failed, size should be 1");
    };

    private static void assertTrue(boolean condition, String message) throws Exception {
        if (!condition) throw new Exception(message);
    }
}
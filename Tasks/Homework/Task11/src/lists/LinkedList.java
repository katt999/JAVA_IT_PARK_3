package lists;

/**
 * Created by EVZabinskaya on 20.10.2017.
 */
public class LinkedList implements List {

    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void add(String element) {
        Node newNode = new Node(element);
        Node current = null;
        if (head == null) {
            head = newNode;
        }
        else {
            LinkedListIterator iterator = new LinkedListIterator();
            while (iterator.hasNext()) {
                current = iterator.currentNode;
                iterator.next();
            }
            current.next = newNode;
        }
        count++;
    }

    private class LinkedListIterator implements Iterator {

        private Node currentNode;

        LinkedListIterator() {
            currentNode = head;
        }

        @Override
        public String next() {
            String element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }
}

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
    public void add(Object element) {
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

    @Override
    public void concat(LinkedList otherList) {
        Node current = null;
        //  LinkedList list = new LinkedList();
        // LinkedList listUnion = new LinkedList();
        //  Iterator iterator = list.iterator();
        // Node headList = list.head;
        Node headOtherList = otherList.head;
        if (head != null) {
            LinkedListIterator iterator = new LinkedListIterator();
            while (iterator.hasNext()) {
                current = iterator.currentNode;
                iterator.next();
            }
            if (headOtherList != null)
            current.next = headOtherList;
        }
    }

    private class LinkedListIterator implements Iterator {

        private Node currentNode;

        LinkedListIterator() {
            currentNode = head;
        }

        @Override
        public Object next() {
            Human element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        private Human value;
        private Node next;

        Node(Object value) {
            this.value = (Human) value;
            this.next = null;
        }
    }
}

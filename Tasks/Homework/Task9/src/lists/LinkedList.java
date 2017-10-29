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
    public void add(int element) {
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
    public void addToBegin(int element) {
        // создали узел для элемента
        Node newNode = new Node(element);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        count++;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int countElements() {
        int counts = 0;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            counts++;
            iterator.next();
        }
        return counts;
    }

    @Override

    public void expand() {
        Node previousNode = null;
        Node currentNode = head;
        while (currentNode != null)
        {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    @Override
    public void addInIndex(int index, int element) {
        int i=0;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            if (i != index) {
                iterator.next();
                i++;
            }
            else break;
        }
        iterator.currentNode.value = element;
    }

    @Override
    public void delIndex(int index) {
        int i=0;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            if (i != index) {
                iterator.next();
                i++;
            }
            else break;
        }
        iterator.currentNode.value = 0;
    }

    @Override
    public void delElement(int element) {
        Node newNode = head;
        while (newNode.next != null) {
            if (newNode.next.value == element)
                newNode.next = newNode.next.next;
            else newNode = newNode.next;
        }
        count--;
    }


    private class LinkedListIterator implements Iterator {

        private Node currentNode;

        LinkedListIterator() {
            currentNode = head;
        }

        @Override
        public int next() {
            int element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

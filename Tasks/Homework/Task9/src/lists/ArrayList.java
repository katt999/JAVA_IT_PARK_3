package lists;

/**
 * Created by EVZabinskaya on 20.10.2017.
 */
public class ArrayList implements List {
    private static final int MAX_SIZE = 10;
    private int elements[];
    private int count;

    public ArrayList() {
        this.elements = new int[MAX_SIZE];
        this.count = 0;
    }

    @Override
    public void add(int element) {
        if (count < MAX_SIZE) {
            elements[count] = element;
            count++;
        } else {
            System.err.println("Нет места");
        }
    }

    @Override
    public void addToBegin(int element) {
        count++;
        if (count < MAX_SIZE) {
            for (int i=count; i > 0; i--) {
                elements[i] = elements[i-1];
            }
            elements[0] = element;
        } else {
            System.err.println("Нет места");
        }
    }

    @Override
    public int countElements() {
        return count;
    }

    @Override
    public void expand() {
        for (int i = 0; i < count / 2; i++) {
            int tmp = elements[i];
            elements[i] = elements[count - i - 1];
            elements[count - i - 1] = tmp;
        }
    }

    @Override
    public void addInIndex(int index, int element) {
        count++;
        if (count < MAX_SIZE) {
            for (int i=count; i > index; i--) {
                elements[i] = elements[i-1];
            }
            elements[index] = element;
        } else {
            System.err.println("Нет места");
        }
    }

    @Override
    public void delIndex(int index) {
        elements[index]=0;
        count--;
    }

    @Override
    public void delElement(int element) {
        int temp=0;
        boolean searchElement = false;
        for (int i=0; i < count; i++) {
            if (elements[i] == element){
                searchElement = true;
                temp = i;
                break;
            }
        }
        if (searchElement) {
            for (int i=temp; i < count-1; i++) {
                elements[i] = elements[i+1];
            }
            elements[count]=0;
            count --;
        }
        else {
            System.err.println("Элемент не найден");
        }
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        private int current;

        public ArrayListIterator() {
            current = 0;
        }

        @Override
        public int next() {
            int element = elements[current];
            current++;
            return element;
        }

        @Override
        public boolean hasNext() {
            return current < count;
        }
    }
}
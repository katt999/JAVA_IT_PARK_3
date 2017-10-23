package lists;

/**
 * Created by EVZabinskaya on 20.10.2017.
 */
public interface List {
    void add(int element);
    void addToBegin(int element);
    int countElements();
    void expand();
    void addInIndex(int index, int element);
    void delIndex(int index);
    void delElement(int element);
    Iterator iterator();
}
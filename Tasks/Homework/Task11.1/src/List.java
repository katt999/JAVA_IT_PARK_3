/**
 * Created by EVZabinskaya on 20.10.2017.
 */
public interface List {
    void add(Object element);
    Iterator iterator();
    void concat(LinkedList otherList);
}
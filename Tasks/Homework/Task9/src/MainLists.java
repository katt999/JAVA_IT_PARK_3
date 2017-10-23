/**
 * Created by EVZabinskaya on 22.10.2017.
 */
import lists.ArrayList;
import lists.Iterator;
import lists.LinkedList;
import lists.List;

public class MainLists {

    public static void printList(List list) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(2);

        LinkedList linkedList = new LinkedList();
        linkedList.addToBegin(6);
        linkedList.addToBegin(8);
        linkedList.addToBegin(9);
        linkedList.addToBegin(1);

        printList(arrayList);
        System.out.println("------------");
        printList(linkedList);
    }
}
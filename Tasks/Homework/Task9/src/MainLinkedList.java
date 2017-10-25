/**
 * Created by EVZabinskaya on 22.10.2017.
 */
import lists.Iterator;
import lists.LinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToBegin(6);
        list.addToBegin(8);
        list.addToBegin(9);
        list.addToBegin(1);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.add(12);
        Iterator iteratorAddEnd = list.iterator();
        System.out.println("Вставка в конец списка: ");
        while (iteratorAddEnd.hasNext()) {
            System.out.println(iteratorAddEnd.next());
        }

        System.out.println("Количество элементов: " + list.countElements());

        list.addInIndex(1, 90);
        Iterator iteratorAddInIndex = list.iterator();
        System.out.println("Вставка по индексу: ");
        while (iteratorAddInIndex.hasNext()) {
            System.out.println(iteratorAddInIndex.next());
        }

        list.delIndex(2);
        Iterator iteratorDelIndex = list.iterator();
        System.out.println("Удаление по индексу: ");
        while (iteratorDelIndex.hasNext()) {
            System.out.println(iteratorDelIndex.next());
        }

        list.delElement(90);
        Iterator iteratorDelElement = list.iterator();
        System.out.println("Удаление по элементу: ");
        while (iteratorDelElement.hasNext()) {
            System.out.println(iteratorDelElement.next());
        }

        list.expand();
        Iterator iteratorExpand = list.iterator();
        System.out.println("Развернутый список: ");
        while (iteratorExpand.hasNext()) {
            System.out.println(iteratorExpand.next());
        }
    }
}
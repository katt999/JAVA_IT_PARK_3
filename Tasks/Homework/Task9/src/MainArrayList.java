/**
 * Created by EVZabinskaya on 22.10.2017.
 */
import lists.ArrayList;
import lists.Iterator;
import lists.List;

public class MainArrayList {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(10);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(2);

        list.addToBegin(3);

        System.out.println("Массив: ");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Всего элементов: " + list.countElements());
        list.expand();
        System.out.println("Развернутый массив: ");
        Iterator iteratorExpanded = list.iterator();
        while (iteratorExpanded.hasNext()) {
            System.out.println(iteratorExpanded.next());
        }

        list.addInIndex(2,20);
        System.out.println("Массив после добавления: ");
        Iterator iteratorAddInIndex = list.iterator();
        while (iteratorAddInIndex.hasNext()) {
            System.out.println(iteratorAddInIndex.next());
        }

        list.delIndex(1);
        System.out.println("Массив после удаоения по индексу: ");
        Iterator iteratorDelIndex = list.iterator();
        while (iteratorDelIndex.hasNext()) {
            System.out.println(iteratorDelIndex.next());
        }

        list.delElement(2);
        System.out.println("Массив после удаления по элементу: ");
        Iterator iteratorDelElement = list.iterator();
        while (iteratorDelElement.hasNext()) {
            System.out.println(iteratorDelElement.next());
        }







       /*

        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }*/

    }
}

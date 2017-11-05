import java.util.Comparator;

/**
 * Created by EVZabinskaya on 01.11.2017.
 */
public class Lists {
    public static <T extends Comparable<T>>
    void bubbleSort(ArrayList<T> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    list.swap(j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparator<T>>
    void sort(ArrayList<T> list, ArrayList<T> list1) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compare(list.get(j + 1)) > 0) {
                    list.swap(j, j + 1);
                }
            }
        }
    }

}

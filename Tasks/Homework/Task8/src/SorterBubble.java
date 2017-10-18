/**
 * Created by EVZabinskaya on 18.10.2017.
 */
public class SorterBubble implements HumanSorter {
    @Override
    public void sort(HumanComparator comparator, Human humans[]){
        Human t;

        for (int i = humans.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(humans[j],humans[j+1])  > 0) {
                    t = humans[j];
                    humans[j] = humans[j + 1];
                    humans[j + 1] = t;
                }
            }
        }

    }
}

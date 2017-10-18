/**
 * Created by EVZabinskaya on 18.10.2017.
 */
public class SorterSelect implements HumanSorter {
    @Override
    public void sort(HumanComparator comparator, Human humans[]){
        int min;
        Human temp;

        for (int index = 0; index < humans.length-1; index++){
            min = index;
            for (int scan = index+1; scan < humans.length; scan++){
                if (comparator.compare(humans[scan],humans[min])  < 0)
                    min = scan;
            }

            temp = humans[min];
            humans[min] = humans[index];
            humans[index] = temp;
        }
    }
}

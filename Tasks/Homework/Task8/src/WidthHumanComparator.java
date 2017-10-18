/**
 * Created by EVZabinskaya on 18.10.2017.
 */
public class WidthHumanComparator  implements HumanComparator {
    @Override
    public int compare(Human a, Human b) {
        return  (int) (a.getWeight() - b.getWeight());
    }
}

/**
 * Created by EVZabinskaya on 18.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        Human Kate = new Human("Kate", 34, 168, 51);
        Human Irina = new Human("Irina", 30, 165, 53);

        AgeHumanComparator ageHumanComparator = new AgeHumanComparator();
        HeightHumanComparator heightHumanComparator = new HeightHumanComparator();
        WidthHumanComparator widthHumanComparator = new WidthHumanComparator();

        int ageDifference = ageHumanComparator.compare(Kate,Irina);
        int heightDifference = heightHumanComparator.compare(Kate,Irina);
        int widthDifference = widthHumanComparator.compare(Kate,Irina);

        System.out.println("Разница в возрасте людей: " + ageDifference);
        System.out.println("Разница в росте людей: " + heightDifference);
        System.out.println("Разница в весе людей: " + widthDifference);

        Human[] humans = new Human[2];
        humans[0] = Kate;
        humans[1] = Irina;

        HumanComparator ageComparator = new AgeHumanComparator();
        HumanComparator widthComparator = new WidthHumanComparator();
        HumanComparator heightComporator = new HeightHumanComparator();

        SorterBubble sorterBubbles = new SorterBubble();
        SorterSelect sorterSelects = new SorterSelect();

        sorterBubbles.sort(ageComparator,humans);
        //sorterBubbles.sort(widthComparator,humans);
        // sorterBubbles.sort(heightComporator,humans);

       // sorterSelects.sort(ageComparator,humans);
       //sorterSelects.sort(widthComparator,humans);
       // sorterSelects.sort(heightComporator,humans);

        for (int j = 0; j < humans.length; j++) {
            System.out.println(humans[j].getName()+ " - рост " + humans[j].getAge() + "см.");
        }
    }
}

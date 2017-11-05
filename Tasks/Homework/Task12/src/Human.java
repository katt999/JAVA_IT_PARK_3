/**
 * Created by EVZabinskaya on 01.11.2017.
 */

public class Human implements Comparable<Human> {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human that) {
        return this.age - that.age;
    }

    @Override
    public int compare(Human that) {
        return this.age - that.age;
    }
}

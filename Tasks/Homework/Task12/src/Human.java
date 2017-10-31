/**
 * Created by EVZabinskaya on 30.10.2017.
 */
public class Human {
    private final int MIN_AGE_VALUE = 0;
    private final int DEFAULT_AGE_VALUE = 0;
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

    public void setAge(int age) {
        if (age >= MIN_AGE_VALUE) {
            this.age = age;
        } else {
            System.err.println("Возраст некорректный.");
            this.age = DEFAULT_AGE_VALUE;
        }
    }

    public String getHuman() {
        String name = this.getName();
        int age = this.getAge();
        String result = name + " - " + age;
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 * Created by EVZabinskaya on 18.10.2017.
 */
public class Human {
    private final int MIN_AGE_VALUE = 0;
    private final int DEFAULT_AGE_VALUE = 0;
    // поля
    private String name;
    private int age;
    private double height;
    private double weight;

    /**
     * Конструктор
     * @param name - имя, поданное на вход
     * @param age - возраст, поданный на вход
     * @param height - рост, поданный на вход
     */
    public Human(String name, int age, double height, double weight) {
//        this.name = name;
//        this.age = age;
//        this.height = height;
        setName(name);
        setAge(age);
        setHeight(height);
        setWeight(weight);
    }

    // метод-процедура - поведение
    public void grow() {
        this.age = age + 1;
    }

    public void grow(int years) {
        this.age = age + years;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setAge(int age) {
        if (age >= MIN_AGE_VALUE) {
            this.age = age;
        } else {
            System.err.println("Возраст некорректный.");
            this.age = DEFAULT_AGE_VALUE;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

package models;

/**
 * Created by EVZabinskaya on 13.11.2017.
 */
public class Human {
    private int id;
    private String name;
    private int age;
    private int height;

    public Human(int id, String name, int age, int height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Human(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Human() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {return height;}

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return this.id + " " + this.age + " "
                + this.name + " " + this.height;
    }
}
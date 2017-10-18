/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        String geometricFigures[] = {"Square", "Rectangle", "Triangle", "Circle", "Oval"};

        for (int i=0; i < geometricFigures.length; i++){
            if (geometricFigures[i].equals("Square")) {
                Square square = new Square("Square", 5);
                square.calculate();
                System.out.println();
                System.out.println(geometricFigures[i] + ":");
                System.out.println("Площадь " + square.getArea());
                System.out.println("Периметр " + square.getPerimeter());
            }
            else if (geometricFigures[i].equals("Rectangle")) {
                Rectangle rectangle = new Rectangle("Rectangle",5,2);
                rectangle.calculate();
                System.out.println();
                System.out.println(geometricFigures[i] + ":");
                System.out.println("Площадь " + rectangle.getArea());
                System.out.println("Периметр " + rectangle.getPerimeter());
            }

            else if (geometricFigures[i].equals("Triangle")) {
                Triangle triangle = new Triangle("Triangle",5,2,6);
                triangle.calculate();
                System.out.println();
                System.out.println(geometricFigures[i] + ":");
                System.out.println("Площадь " + triangle.getArea());
                System.out.println("Периметр " + triangle.getPerimeter());
            }
            else if (geometricFigures[i].equals("Circle")) {
                Circle circle = new Circle("Circle",5);
                circle.calculate();
                System.out.println();
                System.out.println(geometricFigures[i] + ":");
                System.out.println("Площадь " + circle.getArea());
                System.out.println("Периметр " + circle.getPerimeter());
            }
            else if (geometricFigures[i].equals("Oval")) {
                Oval oval = new Oval("Oval",5,6);
                oval.calculate();
                System.out.println();
                System.out.println(geometricFigures[i] + ":");
                System.out.println("Площадь " + oval.getArea());
                System.out.println("Периметр " + oval.getPerimeter());

            }
            else break;
        }
    }
}

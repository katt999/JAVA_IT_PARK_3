/**
 * Created by EVZabinskaya on 04.11.2017.
 */
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static  void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showMainMenu();
            int commandMenu = scanner.nextInt();
            switch (commandMenu) {
                case 1: {
                    System.out.println("Введите Имя, рост и возраст: ");
                    String ownerName = scanner.next();
                    int height = scanner.nextInt();
                    int age = scanner.nextInt();
                    DbOperation.addOwner(ownerName,height,age);
                }
                break;
                case 2: {
                    System.out.println("Введите номер, модель и цвет: ");
                    String number = scanner.next();
                    String model = scanner.next();
                    String color = scanner.next();
                    DbOperation.addCar(number, model, color);
                }
                break;
                case 3: {
                    DbOperation.showOwner();
                }
                break;
                case 4: {
                    DbOperation.showCar();
                }
                break;
                case 5: {
                    System.out.println("Введите имя владельца: ");
                    String ownerName = scanner.next();
                    DbOperation.showOwnerCar(ownerName);
                }
                break;
                case 6: {
                    System.out.println("Введите цвет машины: ");
                    String color = scanner.next();
                    DbOperation.showColorCar(color);
                }
                break;
                case 7: {
                    System.exit(0);
                }
                break;
            }
        }
    }
}


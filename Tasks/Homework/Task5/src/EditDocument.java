/**
 * Created by EVZabinskaya on 04.10.2017.
 */

import java.util.Scanner;

public class EditDocument {

    public static void editDocument(Document document) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showMenu();

            int command = scanner.nextInt();

            switch (command) {
                case 1: {
                    document.showDocument();
                }
                break;
                case 2: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToBegin(newLine);
                }
                break;
                case 3: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToEnd(newLine);
                }
                break;
                case 4: {
                    System.out.println("Введите номер строки: ");
                    Integer positionLine = scanner.nextInt();
                    document.delLine(positionLine);
                }
                case 5: {
                    System.out.println("Введите номер строки, которую нужно заменить: ");
                    Integer positionLine = scanner.nextInt();
                    System.out.println("Введите новую строку: ");
                    String line = scanner.next();
                    document.replaceLine(positionLine, line);
                }
                break;
                case 6: {
                    System.out.println("Введите номер строки: ");
                    Integer positionLine = scanner.nextInt();
                    document.clearLine(positionLine);
                }
                break;
                case 7:
                    return;
            }
        }
    }
}
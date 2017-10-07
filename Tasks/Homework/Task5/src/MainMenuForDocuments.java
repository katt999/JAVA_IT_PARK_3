/**
 * Created by EVZabinskaya on 04.10.2017.
 */
import java.io.IOException;
import java.util.Scanner;

public class MainMenuForDocuments {

    public static int doc(int numstr) {
         Document document = new Document();
        // Обеспечить функционал:
        // добавить строку в конец, в начало, в заданную
        // позицию, заменить строку, удалить строку, вывести весь документ
        Scanner scanner = new Scanner(System.in);
        while (true) {
            MenuDoc.showMenu();

            int command1 = scanner.nextInt();


            switch (command1) {
                case 1: {
                    document.showDocument(numstr);
                }
                break;
                case 2: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToBegin(newLine, numstr);
                }
                break;
                case 3: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToEnd(newLine, numstr);
                }
                break;
                case 4: {
                    System.out.println("Введите номер строки: ");
                    Integer positionLine = scanner.nextInt();
                    document.delLine(positionLine, numstr);
                }
                case 5: {
                    System.out.println("Введите номер строки, которую нужно заменить: ");
                    Integer positionLine = scanner.nextInt();
                    System.out.println("Введите новую строку: ");
                    String line = scanner.next();
                    document.replaceLine(positionLine, line, numstr);
                }
                break;
                case 6: {
                    System.out.println("Введите номер строки: ");
                    Integer positionLine = scanner.nextInt();
                    document.clearLine(positionLine, numstr);
                }
                break;
                case 7:
                    MainMenuForDocuments.main(null);
            }
        }
    }




    public static void main(String[] args) {
        Document documents = new Document();
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            Menu.showMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1: {
                    documents.showDocuments();
                    break;
                }
                case 2: {
                    System.out.println("Введите номер документа: ");
                    Integer numberDocument = scanner.nextInt();
                    doc(numberDocument);
                break;
                }


                case 7:
                    System.exit(0);
            }
        }
    }
}
/**
 * Created by EVZabinskaya on 04.10.2017.
 */
import java.util.Scanner;
import java.io.IOException;

public class MainMenuForDocuments {

    public static void main(String[] args) {
        Document folder[] = new Document[5];
        for (int i = 0; i < folder.length; i++) {
            folder[i] =  new Document();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showMainMenu();

            int commandDoc = scanner.nextInt();

            switch (commandDoc) {
                case 1: {
                    Folder.showFolder(folder);
                }
                break;
                case 2: {
                    System.out.println("Введите номер документа: ");
                    int numberDoc = scanner.nextInt();
                    EditDocument.editDocument(folder[numberDoc]);
                }
                break;
                case 3: {
                    System.out.println("Введите номер документа: ");
                    int numberDoc = scanner.nextInt();
                    Folder.clearDocument(folder, numberDoc);
                }
                break;
                case 4: {
                    System.exit(0);
                }
                break;
             }
        }
   }
}
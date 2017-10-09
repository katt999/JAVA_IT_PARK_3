/**
 * Created by EVZabinskaya on 04.10.2017.
 */
// Класс документ - отдельный файл
// от класса можно создавать ОБЪЕКТЫ
public class Folder {

    static void showFolder(Document folder[]) {
        for (int i = 0; i < folder.length; i++) {
            String lineToOut = (folder[i].count == 0) ? "Документ №"+ i + "(пустой документ)" : "Документ №"+ i;
            System.out.println(lineToOut);
        }
    }
    static void clearDocument(Document folder[], Integer numberDoc) {
        folder[numberDoc] = new Document();
    }

}
/**
 * Created by EVZabinskaya on 04.10.2017.
 */
// Класс документ - отдельный файл
// от класса можно создавать ОБЪЕКТЫ
public class Document {
    // каждый объект класса будет иметь свои копии
    // count и lines
    int count = 0;
    String lines[] = new String[3];

    void showDocument() {
        for (int i = 0; i < lines.length; i++) {
            String lineToOut = lines[i] == null ? "_______" : lines[i];
            System.out.println(i + ": " + lineToOut);
        }
    }

    void addLineToBegin(String newLine) {
        for (int i = count; i > 0; i--) {
            lines[i] = lines[i - 1];
        }
        lines[0] = newLine;
        count++;
    }

    void addLineToEnd(String newLine) {
        lines[count] = newLine;
        count++;
    }

    void delLine(Integer positionLine) {
        for (int i = positionLine; i < count-1; i++) {
            lines[i] = lines[i + 1];
        }
        lines[count-1] = null;
    }

    void replaceLine(Integer positionLine, String line) {
        lines[positionLine] = line;
    }

    void clearLine(Integer positionLine) {
        lines[positionLine] = null;
    }
}
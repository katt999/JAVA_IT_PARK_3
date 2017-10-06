/**
 * Created by EVZabinskaya on 04.10.2017.
 */

public class Document {
    // каждый объект класса будет иметь свои копии
    // count и lines
    int count = 0;
    String lines[][] = new String[5][3];

    void showDocuments() {
        for (int i = 0; i < 5; i++) {
            // тернарный условный оператор e ? a : b
            System.out.println("Документ №" + i);
            for (int j = 0; j < 3; j++) {
                String lineToOut = lines[i][j] == null ? "_______" : lines[i][j];
                System.out.println(j + ": " + lineToOut);
            }
        }
    }

    void showDocument(Integer str) {
        for (int j = 0; j < 3; j++) {
            // тернарный условный оператор e ? a : b
            String lineToOut = lines[str][j] == null ? "_______" : lines[str][j];
            System.out.println(j + ": " + lineToOut);
        }
    }

    void addLineToBegin(String newLine, Integer str) {
        for (int j = count; j > 0; j--) {
            lines[str][j] = lines[str][j - 1];
        }
        lines[str][0] = newLine;
        count++;
    }

    void addLineToEnd(String newLine, Integer str) {
        lines[str][count] = newLine;
        count++;
    }

    void delLine(Integer positionLine, Integer str) {
        for (int j = positionLine; j < count-1; j++) {
            lines[str][j] = lines[str][j + 1];
        }
        lines[str][count-1] = null;
    }

    void replaceLine(Integer positionLine, String line, Integer str) {
       lines[str][positionLine] = line;
    }

    void clearLine(Integer positionLine, Integer str) {
        lines[str][positionLine] = null;
    }
}
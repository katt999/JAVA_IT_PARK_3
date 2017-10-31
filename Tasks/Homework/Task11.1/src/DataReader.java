/**
 * Created by EVZabinskaya on 25.10.2017.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataReader {
    private final static int MAX_STRING_SIZE = 20;

    private InputStream input;

    public DataReader(String fileName) {
        try {
            input = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String readString() {
        try {
            return readString0();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // вовзращает слово из текста, ограниченное небуквенными символами
    private String readString0() throws IOException {
        // текущий массив символов
        char currentWord[] = new char[MAX_STRING_SIZE];
        // количество букв в слове
        int lettersCount = 0;
        // считали первый символ из файла
        int currentByte = input.read();
        // результирющая строка
        String result = null;
        // пока не дошли до конца файла
        while (currentByte != -1) {
            // если символ - буква
            if (currentByte >= 'A' && currentByte <= 'Z' ||
                    currentByte >= 'a' && currentByte <= 'z' ||
                    currentByte == '-' ||
                    currentByte >= '0' && currentByte <= '9') {
                // кидаем в текущий массив символов
                currentWord[lettersCount] = (char)currentByte;
                // увеличиваем количество букв
                lettersCount++;
            } else if (lettersCount != 0){
                // создаем строку на основе массива символов
                // но так как массив символов большой, то мы его обрезаем количеством букв
                result = new String(currentWord, 0, lettersCount);
                // возвращаем результат
                return result;
            }
            // считываем следующий символ
            currentByte = input.read();
        }
        result = new String(currentWord, 0, lettersCount);
        return result;
    }

}

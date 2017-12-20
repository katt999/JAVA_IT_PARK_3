/**
 * Created by EVZabinskaya on 25.10.2017.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();

        DataReader reader = new DataReader("./src/main/resources/name_age.txt");
        String word = reader.readString();

        while (word.length() > 0) {
            arrayList.add(word);
            word = reader.readString();
        }

        int[] arrayAge = arrayList.stream()
                    .map((element) -> element.replaceAll("\\D", ""))
                    .sorted((e1, e2) -> -e1.compareTo(e2))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        int max = 0;
        int number = 0;
        for (int j = 0; j < 100; j++) {
            int count = 0;
            for (int i = 0; i < arrayAge.length; i++) {
                if (j == arrayAge[i]) count++;
            }
            if (max < count) {max = count; number = j;}
         }
        System.out.println("Максимальное количество людей "+ max +" имеют возраст " + number);
    }
}
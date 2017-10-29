/**
 * Created by EVZabinskaya on 25.10.2017.
 */
import lists.Iterator;
import lists.LinkedList;

import java.io.IOException;

public class Main {

    private static int parse(char[] chars) {
        int sum = 0;
        int t = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sum = sum + (chars[i] - '0') * t;
                t *= 10;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        LinkedList[] array = new LinkedList[100];

        for (int i = 0; i < array.length; i++) {
            LinkedList list = new LinkedList();
            array[i] = list;
        }

        DataReader reader = new DataReader("name_age.txt");
        String word = reader.readString();
        while (word.length() > 0) {
            char[] chars = word.toCharArray();
            int age = parse(chars);
            array[age].add(word);
            word = reader.readString();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + ": ");
            Iterator iterator = array[i].iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " -> ");
            }
            System.out.println();
        }
    }
}
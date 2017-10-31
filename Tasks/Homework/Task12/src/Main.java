/**
 * Created by EVZabinskaya on 25.10.2017.
 */

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

        for (int i = 1; i < array.length; i++) {
            LinkedList list = new LinkedList();
            array[i] = list;
        }

        DataReader reader = new DataReader("name_age.txt");
        String word = reader.readString();
        while (word.length() > 0) {
            char[] chars = word.toCharArray();
            int age = parse(chars);
            String name = word.replaceAll("[-0-9]", "");
            array[age].add(new Human(name,age));
            word = reader.readString();
        }

        for (int i = 1; i < array.length; i++) {
            System.out.print(i + ": ");
            Iterator iterator = array[i].iterator();
            while (iterator.hasNext()) {
                Human human = (Human) iterator.next();
                System.out.print(human.getName()+"-"+human.getAge() + " -> ");
            }
            System.out.println();
        }

        //После объединения 1 и 4 листов
        /*System.out.println();
        System.out.println("После объединения 1 и 4 листов:");
        array[1].concat(array[4]);
        Iterator iterator = array[1].iterator();
        while (iterator.hasNext()) {
            Human human = (Human) iterator.next();
            System.out.print(human.getName()+"-"+human.getAge() + " -> ");
        }
        System.out.println();*/

        System.out.println();
        System.out.println("После объединения всех листов:");
        for (int i = 1; i < array.length-1; i++) {
            array[i].concat(array[i+1]);
        }

        //После объединения всех листов
        /*Iterator iterator1 = array[1].iterator();
        while (iterator1.hasNext()) {
            Human human = (Human) iterator1.next();
            System.out.print(human.getName()+"-"+human.getAge() + " -> ");
        }*/

        System.out.println();
        // Первый элемент объединенного списка
        Iterator iterator1 = array[1].iterator();
        int j=1;
        while (iterator1.hasNext()) {
            Human human = (Human) iterator1.next();
            System.out.print(human.getName()+"-"+human.getAge() + " -> ");
            j++;
            if (j>1) break;
        }
    }
}
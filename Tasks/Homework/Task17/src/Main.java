import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by EVZabinskaya on 28.11.2017.
 */
public class Main {
    public static boolean numberFound = false;
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int row = scanner.nextInt();
        System.out.println("Введите количество столбцов");
        int column = scanner.nextInt();
        System.out.println("Введите число для поиска");
        int number = scanner.nextInt();
        int[][] matrix = new int[row][column];

        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(1000);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; ++j) {
                System.out.print(matrix[i][j] + " ");
             }
            System.out.println();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; ++j) {
                int element = matrix[i][j];
                int rowPosition = i;
                int columnPosition = j;
                service.submit(() -> {
                            if (element == number && !numberFound) {
                                System.out.println("Искомое число найдено на позиции: [" + rowPosition + "][" + columnPosition + "]");
                                numberFound = true;
                                service.shutdown();
                            }
                        }
                );
          }

        }
       if (!numberFound)  System.out.println("Искомое число не найдено");
    }
}


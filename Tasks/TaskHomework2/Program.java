import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();		
		int money5000 = number / 5000;
		number = number - 5000*money5000;
		int money1000 = number / 1000;
		number = number - 1000*money1000;
		int money500 = number / 500;
		number = number - 500*money500;
		int money100 = number / 100;
		number = number - 100*money100;
		int money50 = number / 50;
		number = number - 50*money50;
		int money10 = number / 10;
		number = number - 10*money10;
		int money5 = number / 5;
		number = number - 5*money5;
		int money2 = number / 2;
		number = number - 2*money2;
		int money1 = number / 1;
		number = number - 1*money1;

        System.out.println("money 5000 - " + money5000 +
        	",money 1000 - " + money1000 +
        	",money 500 - " + money500 +
        	",money 100 - " + money100 +
        	",money 50 - " + money50 +
        	",money 10 - " + money10 +
        	",money 5 - " + money5 +
            ",money 2 - " + money2 +
            ",money 1 - " + money1);
	}
}
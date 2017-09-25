import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();		
		int x0 = number % 2;
<<<<<<< HEAD
		number = number / 2; 
		int x1 = number % 2;
		number = number / 2; 
		int x2 = number % 2;
		number = number / 2; 
		int x3 = number % 2;
		number = number / 2; 
		int x4 = number % 2;
		number = number / 2; 
		int x5 = number % 2;
		number = number / 2; 
		int x6 = number % 2;
		number = number / 2; 
		int x7 = number % 2;
		number = number / 2; 

		System.out.println(x7 
			+ "" 
=======
		number = number / 2;
		int x1 = number % 2;
		number = number / 2;
		int x2 = number % 2;
		number = number / 2;
		int x3 = number % 2;
		number = number / 2;
		int x4 = number % 2;
		number = number / 2;
		int x5 = number % 2;
		number = number / 2;
		int x6 = number % 2;
		number = number / 2;
		int x7 = number % 2;
		
		System.out.println(x7 + "" 
>>>>>>> 8f17ef1f6b31e750fc8fb05174b336dad7e00502
			+ x6 + "" 
			+ x5 + "" 
			+ x4 + ""
			+ x3 + ""
			+ x2 + ""
			+ x1 + ""
			+ x0);

	}
}
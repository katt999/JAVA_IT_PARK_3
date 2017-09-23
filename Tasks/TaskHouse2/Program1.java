import java.util.Scanner;
class Program1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sumx = 0;
		for (int i = 0; i < 999; i++) {	
		  sumx = sumx + scanner.nextInt();	
		}
		int sum = 1000*(1000+1)/2; 
		int y = sum-sumx;
		
		System.out.println("y=" + y);

	}
}
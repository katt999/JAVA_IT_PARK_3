
public class Main {

    public static int parse(char digits[]) {
        int[] ascii = new int[10];
        int k = 48;
        for (int j=0; j < 10; j++){
            ascii[j] = k;
            k++;
        }
        int sum = 0;
        for (int i=0; i < digits.length; i++){
            int d=1;
            int z = (int)digits[i];
            for (int r=1; r < digits.length-i; r++) {
                d = d * 10;
            }
            for  (int j=0; j < ascii.length; j++) {
                if (z == ascii[j])
                    sum = sum+j*d;
            }
        }
        return sum;
    }

    public static void main (String args[]) {

        char number[] = {'3', '2', '4', '1'};
        int numberAsInt = parse(number);
        System.out.println(numberAsInt);


}


}

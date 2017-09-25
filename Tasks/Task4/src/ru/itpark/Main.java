package ru.itpark;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 3, 10};
        int length = arr.length;
       /* for (int i=0;i < length/2;i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }

        for (int i=0;i < length;i++) {
            System.out.print(arr[i] + " ");
        }*/
        int min = arr[0];
        int minp = 0;
        for (int i=1;i < length;i++) {
            if (arr[i] < min) {
                min= arr[i];
                minp = i;
            }
        }
        int max = arr[0];
        int maxp = 0;
        for (int i=1;i < length;i++) {
            if (arr[i] > max) {
                max= arr[i];
                maxp = i;
            }
        }
        int tempmin = arr[minp];
        int tempmax = arr[maxp];
        arr[minp] = tempmax;
        arr[maxp] = tempmin;
        for (int i=0;i < length;i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

 import java.util.Scanner;

 class Main {

    public static void main(String[] args) {
        int[] array = {2, 0, 4, 7, 8, 3, 10};     
        //int[] array = {0, 0, 5, 7, 8, 11, 3};         
        int sumChet = 0;
        int sumNechet = 0;
        int sumChetPozicion = 0;
        int sumNechetPozicion = 0;
        int kolLokMax = 0;
        int maxLenghtTemp = 0; 
        int maxLenght = 0;  

        for (int i=0;i < array.length;i++) {

            if (array[i] % 2 == 0) 
               sumChet = sumChet + array[i];
            else
               sumNechet = sumNechet + array[i];

            if (i % 2 == 0) 
               sumChetPozicion = sumChetPozicion + array[i];
            else
               sumNechetPozicion = sumNechetPozicion + array[i];

        }

        for (int i=1;i < array.length-1;i++) {

            if (array[i-1] < array[i] && array[i] > array[i+1]) 
                kolLokMax++; 
        }

        for (int i=0;i < array.length-1;i++) {
              
                if (array[i] < array[i+1]) {                    
                    maxLenghtTemp++;                    
                }
                else {                     
                    if (maxLenght < maxLenghtTemp)
                       maxLenght = maxLenghtTemp+1; 
                    maxLenghtTemp = 0;
                }

        }   

        for (int i=0;i < array.length;i++) {
              
                if (array[i] == 0)                     
                    array[i] = array[i+1]*(-1);                 
                
        }   
        
        System.out.println("Сумма четных элеменов - " + sumChet + ", Сумма четных элеменов - " + sumNechet);
        System.out.println("Сумма элеменов на четных позициях - " + sumChetPozicion + ", Сумма  элеменов на нечетных позициях - " + sumNechetPozicion);
        System.out.println("Количество локальных максимумов - " + kolLokMax);
        System.out.println("Длина максимально длинной подпоследовательности - " + maxLenght);
        System.out.println("Последовательность с заменой 0: ");
        for (int i=0;i < array.length;i++) {
             System.out.print(array[i]+" ");
        }

    }
}

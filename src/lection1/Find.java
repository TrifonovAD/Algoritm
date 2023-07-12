package lection1;


import java.util.Random;

public class Find {
    public static void main(String[] args) {
        int[] array = new int[30];

        for (int i = 0; i < array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(50);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
        System.out.println();

        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
        System.out.println();

        Random random = new Random();
        int value = random.nextInt(50);
        System.out.println("=============== Бинарный поиск числа ===============");
        System.out.println("Value = " + value);
        System.out.println("Индекс искомого элемента: " + binarySearch(array, value));

    }
    public static int findElement(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;

        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] > value) {
            return binarySearch(array, value, min, midpoint - 1);
        } else if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        }
        else return midpoint;


    }
    public static void bubbleSort(int[] array) {
        boolean finish;
        do{
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }
}

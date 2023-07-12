package lection1;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[31];

        for (int i = 0; i < array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
        System.out.println();
        quickSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    public static void quickSort(int[] array, int startPosition, int endPosition) {

        int pivot = array[(startPosition + endPosition) / 2];

        int leftPosition = startPosition;
        int rightPosition = endPosition;


        while (leftPosition <= rightPosition) {

            while (array[leftPosition] < pivot) {
                leftPosition++;
            }

            while (array[rightPosition] > pivot) {
                rightPosition--;
            }

            if (leftPosition <= rightPosition) {
                int temp = array[leftPosition];
                array[leftPosition] = array[rightPosition];
                array[rightPosition] = temp;
                leftPosition++;
                rightPosition--;
            }

        }

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }
}

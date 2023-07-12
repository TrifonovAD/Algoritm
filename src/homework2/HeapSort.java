package homework2;

import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
        System.out.println();
        heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");;
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n * 2 - 1; i >= 0; i--) {
            heapify(array, i, n);

        }

        for (int i = n - 1; i >=0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }
    }

    private static void heapify(int[] array, int i, int n) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;

        if (leftChild < n && array[leftChild] > array[i]) {
            largest = leftChild;
        }
        if (rightChild < n && array[rightChild] > array[i]) {
            largest = rightChild;
        }
        if (i != largest) {
            int temp = array[i];
            array[i] = array [largest];
            array[largest] = temp;

            heapify(array, largest, n);
        }
    }

}

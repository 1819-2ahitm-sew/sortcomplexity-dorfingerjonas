package at.htl;

import java.util.*;

public class SortComplexity {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        int howManyArrays = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        int howManyElements = scanner.nextInt();

        int[] times = new int[howManyArrays];

        System.out.println();

        for (int i = 0; i < howManyArrays; i++) {
            times[i] = (int) sortRandomArray(howManyElements);
            System.out.println("Laufzeit zur Sortierung des " + (i+1) + ". Arrays: " + times[i] + "ms");
        }

        System.out.println("\nDurchschnittliche Laufzeit: " + getAverageSortTime(times) + "ms");

    }

    private static int getAverageSortTime(int[] times) {
        int sum = 0;

        for (int time : times) {
            sum += time;
        }
        return sum / times.length;
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int[] array = generateRandomArray(length);
        long startTime = System.currentTimeMillis();

        sort(array);

        long stopTime = System.currentTimeMillis();

        return stopTime - startTime;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();

        int[] randomArray = new int[length];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(2000);
        }
        return randomArray;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {

        int k;

        for (int i = 1; i < array.length; i++) {
            k = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > k) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = k;
        }
    }
}
package com.solvd.laba.university.task1;

public class SortingAlgorithm {
    public static void insertionSort(long[] array) {
// iterate over each element starting from the second one
        for (int i = 1; i < array.length; i++) {
            long key = array[i];
            int low = 0;
            int high = i - 1;

// binary search for the correct position of the key
            while (low <= high){
                int mid = low + (high - low) / 2;

                if (array[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
// position where the key should be inserted
            int position = low;
// move elements to the right to make space for the key
            if (position < i) {
                System.arraycopy(array, position, array, position + 1, i - position);
            }
// insert the key into correct position
            array[position] = key;
        }
    }

    // check if the list is not empty
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a list of numbers to sort.");
            return;
        }
// array for keeping correct numbers
        long[] tempArray = new long[args.length];
        int validCount = 0;
// adding correct numbers to temporary array
        for (String arg : args) {
            try{
                long number = Long.parseLong(arg);
                tempArray[validCount] = number;
                validCount++;
            } catch (NumberFormatException e) {
                System.out.println("Ignoring invalid number: " + arg);
            }
        }
// create array of the correct size for valid numbers
        long[] array = new long[validCount];
// copy from tempArray to array
        System.arraycopy(tempArray, 0, array, 0, validCount);

        if (array.length == 0) {
            System.out.println("No valid numbers provided to sort.");
            return;
        }

// print array before sorting
        System.out.println("Array before sorting:");
        for (long i : array) {
            System.out.println(i + " ");
        }
        System.out.println();

// sorting
        insertionSort(array);

// printing out array after sorting
        System.out.println("Sorted array:");
        for (long i : array) {
            System.out.print(i + " ");
        }
    }
}

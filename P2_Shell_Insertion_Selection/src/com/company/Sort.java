package com.company;
import java.util.*;

public class Sort {

    /* An utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* function to sort arr using shellSort */
    static void selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    /*Function to sort array using insertion sort*/
    static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    /* function to sort arr using shellSort */
    static int shellSort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }

   //Method to print shell sort
    public static void printShellSort(){
        Random rgen = new Random();  // Random number generator
        int[] arr = new int[100000];  //array to store 100000 random integers (1-100,000)

        //--- Initialize the array to the ints 1-10,000
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        //--- Shuffle by exchanging each element randomly
        for (int i=0; i<arr.length; i++) {
            int randomPosition = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }

        System.out.println("Array before Shell sort");
        printArray(arr);
        System.out.println();

        long shellStartTime = System.currentTimeMillis();
        final int shellSort = shellSort(arr);
        long ShellEndTime   = System.currentTimeMillis();
        long totalTime = ShellEndTime - shellStartTime;

        System.out.println("Array after Shell Sort");
        printArray(arr);
        System.out.println("Run time is:  " + totalTime);
        System.out.println();
        System.out.println();



    }

    //Method to print shell sort
    public static void printInsertionSort(){

//        int arr[] = new int[1000];
//        for(int i = 0; i < 1000; i++){
//            arr[i] = (int)(Math.random()*1000);
//        }

        Random rgen = new Random();  // Random number generator
        int[] arr = new int[100000];  //array to store 100000 random integers (1-100,000)

        //--- Initialize the array to the ints 1-10,000
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        //--- Shuffle by exchanging each element randomly
        for (int i=0; i<arr.length; i++) {
            int randomPosition = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }

        System.out.println("Array before Insertion Sort");
        printArray(arr);
        System.out.println();

        long insertionStartTime = System.currentTimeMillis();
        insertionSort(arr);
        long insertionEndTime   = System.currentTimeMillis();
        long totalTime = insertionEndTime - insertionStartTime;

        System.out.println("Array after Insertion Sort");
        printArray(arr);
        System.out.println("Run time is:  " + totalTime);
        System.out.println();
        System.out.println();

    }

    //Method to print shell sort
    public static void printSelectionSort(){

        Random rgen = new Random();  // Random number generator
        int[] arr = new int[100000];  //array to store 100000 random integers (1-100,000)

        //--- Initialize the array to the ints 1-10,000
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        //--- Shuffle by exchanging each element randomly
        for (int i=0; i<arr.length; i++) {
            int randomPosition = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }

        System.out.println("Array before Selection Sort");
        printArray(arr);
        System.out.println();

        long selectionStartTime = System.currentTimeMillis();
        selectionSort(arr);
        long selectionEndTime   = System.currentTimeMillis();
        long totalTime = selectionEndTime - selectionStartTime;

        System.out.println("Array after Selection Sort");
        printArray(arr);
        System.out.println("Run time is:  " + totalTime);
        System.out.println();
        System.out.println();

    }

    // Driver method
    public static void main(String args[])
    {
        printShellSort();

        printInsertionSort();

        printSelectionSort();

    }
}

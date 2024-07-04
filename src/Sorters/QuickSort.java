package Sorters;

import java.util.ArrayList;

public class QuickSort {

    public static void sort(ArrayList<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (list.get(j) < pivot) {
                i++;

                // swap list[i] and list[j]
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // swap list[i+1] and list[high] (or pivot)
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
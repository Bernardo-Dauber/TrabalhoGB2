package Sorters;

import java.util.ArrayList;

public class SelectionSort {

    public static void sort(ArrayList<Integer> list) {
        int n = list.size();

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(min_idx)) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
    }
}
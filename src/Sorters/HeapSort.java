package Sorters;

import java.util.ArrayList;

public class HeapSort {

    public static void sort(ArrayList<Integer> list) {
        int n = list.size();


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }


        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);


            heapify(list, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in list[]
    // n is size of heap
    private static void heapify(ArrayList<Integer> list, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && list.get(left) > list.get(largest)) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && list.get(right) > list.get(largest)) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}
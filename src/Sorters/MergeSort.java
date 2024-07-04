package Sorters;

import java.util.ArrayList;

public class MergeSort {

    public static void sort(ArrayList<Integer> list) {
        if (list.size() < 2) {
            return;
        }

        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(mid);
        ArrayList<Integer> right = new ArrayList<>(list.size() - mid);

        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }

        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }

        sort(left);
        sort(right);

        merge(list, left, right);
    }

    private static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // A utility function to print the array
    public static void printArray(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
import Sorters.BubbleSort;

import java.util.ArrayList;

public class SortingPerformanceTest {


    public static void main(String[] args) {
        // Tamanhos dos arrays a serem testados
        int[] arraySizes = {128,256 ,512 ,1024 ,2048 ,4096, 8192, 16384, 32768, 65536};

        // Testar Bubble Sort para cada tamanho de array nos diferentes cenários
        for (int size : arraySizes) {
            System.out.println("Tamanho do array: " + size);

            // Gerar os arrays com a classe ArraySorter
            ArrayList<Integer> ascending = ArraySorter.sortAscending(size);
            ArrayList<Integer> descending = ArraySorter.sortDescending(size);
            ArrayList<Integer> randomNoRepeats = ArraySorter.sortRandom(size);
            ArrayList<Integer> randomWithRepeats = ArraySorter.sortWithRepeats(size);

            // Testar Bubble Sort nos diferentes cenários
            testBubbleSort(ascending, "Bubble Sort (Ordenado crescente)");
            testBubbleSort(descending, "Bubble Sort (Ordenado decrescente)");
            testBubbleSort(randomNoRepeats, "Bubble Sort (Aleatório sem repetições)");
            testBubbleSort(randomWithRepeats, "Bubble Sort (Aleatório com repetições)");

            System.out.println();
        }
    }

    private static void testBubbleSort(ArrayList<Integer> list, String scenario) {
        long startTime, endTime;
        ArrayList<Integer> copy = new ArrayList<>(list);

        startTime = System.currentTimeMillis();
        BubbleSort.sort(copy);
        endTime = System.currentTimeMillis();

        System.out.println(scenario + ": " + (endTime - startTime) + " ms");
    }
}

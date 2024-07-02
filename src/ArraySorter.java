import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArraySorter {

    // Método 1: Ordenar crescente
    public static ArrayList<Integer> sortAscending(int size) {
        ArrayList<Integer> list = generateRandomList(size);
        Collections.sort(list);
        return list;
    }

    // Método 2: Ordenar decrescente
    public static ArrayList<Integer> sortDescending(int size) {
        ArrayList<Integer> list = generateRandomList(size);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    // Método 3: Ordenar aleatório sem repetições
    public static ArrayList<Integer> sortRandom(int size) {
        ArrayList<Integer> list = generateRandomList(size);
        Collections.shuffle(list);
        return list;
    }

    // Método 4: Ordenar aleatório com valores repetidos
    public static ArrayList<Integer> sortWithRepeats(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(size / 2); // Permitindo valores repetidos
            list.add(value);
        }
        Collections.sort(list);
        return list;
    }

    // Método auxiliar para gerar uma lista com números aleatórios
    private static ArrayList<Integer> generateRandomList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(size));
        }
        return list;
    }
}

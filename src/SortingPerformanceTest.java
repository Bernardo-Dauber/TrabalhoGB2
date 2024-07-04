import Sorters.*;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//128, 256, 512, 1024, 2048, 4096, 8192,
public class SortingPerformanceTest {
//Professora não conseguir rodar a partir de 16.384, então não preenchi a tabela
    public static void main(String[] args) {
        // Tamanhos dos arrays a serem testados
        int[] arraySizes = {128, 256, 512, 1024, 2048, 4096, 8192};

        // HashMap para armazenar os tempos de execução de cada tipo de array por tamanho
        Map<String, Map<Integer, ArrayList<Integer>>> temposPorTipoETamanho = new HashMap<>();
        for (String tipo : new String[]{"ascending", "descending", "randomNoRepeats", "randomWithRepeats"}) {
            temposPorTipoETamanho.put(tipo, new HashMap<>());
            for (int size : arraySizes) {
                temposPorTipoETamanho.get(tipo).put(size, new ArrayList<>());
            }
        }

        // Testar Bubble Sort para cada tamanho de array nos diferentes cenários
        for (int i = 0; i < 10; i++) {
            for (int size : arraySizes) {
                // Gerar os arrays com a classe ArraySorter
                ArrayList<Integer> ascending = ArraySorter.sortAscending(size);
                ArrayList<Integer> descending = ArraySorter.sortDescending(size);
                ArrayList<Integer> randomNoRepeats = ArraySorter.sortRandom(size);
                ArrayList<Integer> randomWithRepeats = ArraySorter.sortWithRepeats(size);

                // Testar Bubble Sort nos diferentes cenários e armazenar os tempos
                temposPorTipoETamanho.get("ascending").get(size).add(test(ascending));
                temposPorTipoETamanho.get("descending").get(size).add(test(descending));
                temposPorTipoETamanho.get("randomNoRepeats").get(size).add(test(randomNoRepeats));
                temposPorTipoETamanho.get("randomWithRepeats").get(size).add(test(randomWithRepeats));
            }
        }

        // Imprimir soma dos tempos de execução para cada tipo de array e tamanho
        for (String tipo : temposPorTipoETamanho.keySet()) {
            for (int size : temposPorTipoETamanho.get(tipo).keySet()) {
                ArrayList<Integer> tempos = temposPorTipoETamanho.get(tipo).get(size);
                double media = calcularMedia(tempos);
                double variancia = calcularVariancia(tempos, media);
                double desvioPadrao = Math.sqrt(variancia);
                ArrayList<Integer> temposFiltrados = filtrarTempos(tempos, media, desvioPadrao);
                double novaMedia = calcularMedia(temposFiltrados);
                System.out.println(String.format("Nova média dos tempos de execução para %s com tamanho %d: %.2f", tipo, size, novaMedia));
            }
        }
    }

    public static int test(ArrayList<Integer> list) {
        long startTime, endTime;
        ArrayList<Integer> copy = new ArrayList<>(list);

        startTime = System.currentTimeMillis();
        BubbleSort.sort(copy);
        endTime = System.currentTimeMillis();
        long t = endTime - startTime;
        return (int) t;
    }

    public static double calcularMedia(ArrayList<Integer> tempos) {
        double soma = 0;
        for (int tempo : tempos) {
            soma += tempo;
        }
        return soma / tempos.size();
    }

    public static double calcularVariancia(ArrayList<Integer> tempos, double media) {
        double soma = 0;
        for (int tempo : tempos) {
            soma += Math.pow(tempo - media, 2);
        }
        return soma / (tempos.size() - 1);
    }

    public static ArrayList<Integer> filtrarTempos(ArrayList<Integer> tempos, double media, double desvioPadrao) {
        ArrayList<Integer> filtrados = new ArrayList<>();
        for (int tempo : tempos) {
            if (tempo >= media - desvioPadrao && tempo <= media + desvioPadrao) {
                filtrados.add(tempo);
            }
        }
        return filtrados;
    }
}

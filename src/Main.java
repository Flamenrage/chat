import comparisons.ChainHashUsage;
import comparisons.HashTablesComparison;
import comparisons.TreeUsage;
import structures.Tree;
import structures.hash_table.LinearHashTable;
import structures.hash_table.QuadraticHashTable;
import utils.ArrayUtils;


public class Main {

    public static void main(String[] args) throws Exception {
        // СОРТИРОВКА
        // Для TreeSort использовать только метод generateRandomUniqueArray !!!
        int[] array = ArrayUtils.generateRandomArray(100, 1, 100);
//        ArrayUtils.print(array);
////        Recorder.start();
////        int[] sortedArr = BubbleSort.sort(array);
////        Recorder.stop();
////        System.out.println("\nBubble-sort:\n");
////        Recorder.printTimeAndMemoryUsage();
////        ArrayUtils.print(sortedArr);

        // БИНАРНОЕ ДЕРЕВО ПОИСКА
        //TreeUsage.run(10000, false);
        ChainHashUsage.run();
        //СРАВНЕНИЕ ХЭШ-ТАБЛИЦ
        /*int size = 10;
        HashTablesComparison.compare(
                new LinearHashTable(size),
                new QuadraticHashTable(size),
                size,
                true
        );*/

        //СРАВНЕНИЕ СВЯЗНОГО СПИСКА И МАССИВА
        //ArrayAndListComparison.compare(10000);

        //https://github.com/D4Gj/gos/blob/main/1.txt
    }
}

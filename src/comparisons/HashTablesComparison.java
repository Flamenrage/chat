package comparisons;

import structures.hash_table.HashTable;
import utils.ArrayUtils;
import utils.Recorder;

public class HashTablesComparison {

    public static void compare(HashTable table1, HashTable table2, int tablesSize, boolean withPrint) throws Exception {
        // Генерируем большое кол-во уникальных чисел
        int[] elements = ArrayUtils.generateRandomUniqueArray(tablesSize * 100);
        // И оставляем из них только кол-во, достаточное для заполнения 3/4 хэш-таблицы
        int[] temp = new int[tablesSize * 3/4];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;


        HashTable[] tables = new HashTable[]{table1, table2};
        for (HashTable table: tables) {
            System.out.println();
            System.out.println("----- " + table.getClass().getSimpleName());

            System.out.println("ADD");
            Recorder.start();
            for (int elem: elements) {
                table.add(elem, String.valueOf(elem));
            }
            Recorder.stop();
            Recorder.printTimeAndMemoryUsage();

            System.out.println("GET");
            Recorder.start();
            for (int elem: elements) {
                table.getValue(elem);
            }
            Recorder.stop();
            Recorder.printTimeAndMemoryUsage();

            if (withPrint) {
                System.out.println("Table PRINT:");
                table.printAll();
            }

            System.out.println("DELETE");
            Recorder.start();
            for (int elem: elements) {
                table.delete(elem);
            }
            Recorder.stop();
            Recorder.printTimeAndMemoryUsage();
        }
    }
}

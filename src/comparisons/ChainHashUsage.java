package comparisons;

import structures.hash_table.ChainHashTable;

public class ChainHashUsage {

    public static void run() {
        ChainHashTable table = new ChainHashTable(10);
        table.add(5, "five");
        table.add(15, "fifteen");
        table.add(3, "three");
        table.add(33, "thirty three");
        table.add(0, "zero");
        table.add(9, "nine");
        if (table.contains(9)) {
            System.out.println("table contains 9");
        }
        System.out.println(table.getValueByKey(9));
        table.printSelf();
        table.delete(0);
        System.out.println();
        System.out.println();
        table.rehash(20);
        table.printSelf();
        if (table.contains(33)) {
            System.out.println(table.getValueByKey(33));
        }
        table.delete(33);
    }
}

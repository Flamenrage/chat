package comparisons;

import structures.Tree;
import utils.ArrayUtils;
import utils.Recorder;

public class TreeUsage {
    public static void run(int elementsCount, boolean withPrint) {
        Tree tree = new Tree();
        int[] numbers = ArrayUtils.generateRandomUniqueArray(elementsCount);
        System.out.println();
        System.out.println("Tree Insert:\n");
        Recorder.start();
        for (int number: numbers){
            tree.add(number);
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();

        System.out.println();
        System.out.println("Tree Contains:\n");
        Recorder.start();
        for (int number: numbers){
            tree.contains(number);
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();

        if (withPrint) {
            tree.printInOrder();
        }

        System.out.println();
        System.out.println("Tree Delete:\n");
        Recorder.start();
        for (int number: numbers){
            tree.delete(number);
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();
    }
}

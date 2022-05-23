package comparisons;

import structures.LinkedList;
import utils.Recorder;

import java.util.ArrayList;

public class ArrayAndListComparison {

    public static void compare(int length) {
        System.out.println("ARRAY");
        int[] a = new int[length];
        Recorder.start();
        for (int i = 0; i < length; i++) {
            a[i] = 42;
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();
        System.out.println();
        System.out.println();
        System.out.println("LINKED LIST");
        LinkedList list = new LinkedList();
        Recorder.start();
        for (int i = 0; i < length; i++) {
            list.add(42);
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();
        System.out.println();
        System.out.println();
        System.out.println("JAVA ARRAYLIST");
        ArrayList<Integer> arrList = new ArrayList<>();
        Recorder.start();
        for (int i = 0; i < length; i++) {
            arrList.add(42);
        }
        Recorder.stop();
        Recorder.printTimeAndMemoryUsage();
    }
}

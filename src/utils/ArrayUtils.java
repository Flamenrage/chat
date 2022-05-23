package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayUtils {

    public static int[] generateRandomArray(int length, int min, int max) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(max - min) + min;
        }
        return result;
    }

    public static int[] generateRandomUniqueArray(int length) {
        ArrayList<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] result = new int[length];
        Object[] shuffled = list.toArray();
        for (int i = 0; i < length; i++) {
            result[i] = (int)shuffled[i];
        }
        return result;
    }

    public static void print(int[] a) {
        System.out.println();
        for(int elem: a) {
            System.out.print(elem + " ");
        }
    }
}

package utils;

public class Recorder {
    private static long finishMemory = 0;
    private static long startTime = 0;
    private static long finishTime = 0;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        finishTime = System.currentTimeMillis();
        finishMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static void printTimeAndMemoryUsage() {
        System.out.println();
        System.out.println("TIME: " + (finishTime - startTime) + " ms");
        System.out.println("MEMORY: " + finishMemory + " bytes (" + finishMemory / 1024 + " kb)");
    }
}

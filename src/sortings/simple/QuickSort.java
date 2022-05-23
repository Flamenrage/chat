package sortings.simple;

/**
 * Быстрая сортировка
 *
 * Выбрать из массива элемент-стержень F, его значение
 * наиболее близко к среднему арифметическому.
 * Запускается процедура разделения массива, которая
 * перемещает все элементы, меньшие либо равные F, влево от него,
 * а все элементы, большие либо равные F, вправо.
 * Теперь массив состоит из двух подмножеств, причем левое меньше правого.
 * Для обоих подмассивов: если в подмассиве более двух элементов,
 * рекурсивно запускаем для него ту же процедуру,
 * если элементов два, то при необходимости меняем их местами.
 *
 *  * Сложность:
 *  * время: луч. W(N * log(N)) сред. T(N * log(N)) худ. O(N ^ 2)
 *  * память: O(log(N))
 */

public class QuickSort {

    public static int[] sort(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private static void quickSort(int[] a, int leftBound, int rightBound)
    {
        if (leftBound < rightBound)
        {
            // Точка-стержень, делящая массив на 2 подмассива
            int pIndex = partition(a, leftBound, rightBound);
            // Рекурсивно сортируем подмассивы
            quickSort(a, leftBound, pIndex - 1);
            quickSort(a, pIndex + 1, rightBound);
        }
    }

    /**
     *  Функция выбирает последний элемент в качестве стержня,
     *  помещает его на верную позиция в отсортированном массиве
     *  и перемещает все элементы меньшие стержня налево от него
     */
    private static int partition(int[] arr, int leftBound, int rightBound)
    {
        // точка-стержень
        int pivot = arr[rightBound];
        // индекс наименьшего элемента
        int i = (leftBound - 1);
        for(int j = leftBound; j <= rightBound - 1; j++)
        {
            // если текущий элемент меньше стержневого
            if (arr[j] < pivot)
            {
                // сдвигаем индекс наименьшего элемента
                i++;
                // вставляем элемент слева от стержня
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, rightBound);
        return (i + 1);
    }

    /**
     * Меняет местами i-й и j-й элементы
     */
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

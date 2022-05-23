package sortings.structure_based;
import structures.Heap;

/**
 *  Пирамидальная сортировка (сортировка кучей)
 *
 *  Использует двоичную кучу, в которой на вершине всегда находится минимальный элемент.
 *  Элементы поочерёдно добавляются в кучу, а потом извлекаются обратно
 *  в отсортированном порядке
 *
 *  Время: O(N * log(N))
 *  Требует O(1) дополнительной памяти
 */
public class HeapSort {

    public static int[] sort(int[] a) {
        Heap heap = new Heap(a.length);
        for (int elem: a) {
            heap.add(elem);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = heap.pullMinElement();
        }
        return a;
    }
}

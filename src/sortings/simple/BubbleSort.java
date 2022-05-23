package sortings.simple;

/**
 * Пузырьковая сортировка
 *
 * Проходим по массиву N-1 раз. В каждом проходе попарно
 * сравниваем соседние элементы. Если порядок двух элементов
 * неверный, меняем их местами.
 * Сложность:
 * время: луч. W(N) сред. T(N^2) худ. O(N^2)
 * память: O(1)
 *
 */
public class BubbleSort {

    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < (a.length - 1) - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }
}

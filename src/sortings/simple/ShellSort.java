package sortings.simple;

/**
 * Сортировка Шелла
 *
 * Усовершенствованный вариант сортировки вставками.
 * Сначала выбирается смещение h(обычно N/2 или N/3).
 * После этого отдельно сортируются все элементы, расстояние между которыми h.
 * Отдельная сортировка повторяется h раз (h-1 сдвигов).
 * Затем производится обычная сортировка вставками.
 *
 *   Сложность:
 *  время: луч. W(N * log(N)) сред. T(N * log(N)^2) худ. O(N * log(N)^2)
 *  память: O(1)
 */

public class ShellSort {

    public static int[] sort(int[] arr)
    {
        int n = arr.length;
        // Начинаем с большого интервала, затем уменьшаем его
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Выполняем сортировку вставками, для элементов, лежащих на расстоянии равном gap
            for (int i = gap; i < n; i += 1)
            {
                // добавляем в отсортированную часть новый элемент
                int temp = arr[i];
                // продвигаемся влево, пока не найдём подходящее место для нового элемента
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                // вставляем элемент
                arr[j] = temp;
            }
        }
        return arr;
    }
}

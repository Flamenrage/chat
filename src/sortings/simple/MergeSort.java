package sortings.simple;

/**
 * Сортировка слиянием
 *
 * Рекурсивная.
 * Сортируемый массив разбивается на две примерно одинаковые части.
 * Каждая из частей сортируется отдельно тем же алгоритмом.
 * Два упорядоченных подмассива соединяются в один.
 * Разбиение происходит до тех пор, пока размер массива не достигнет единицы.
 *
 *  * Сложность:
 *  * время: луч. W(N * log(N)) сред. T(N * log(N)) худ. O(N * log(N))
 *  * память: O(N)
 */

public class MergeSort {

    public static int[] sort(int a[]) {
        return sort(a, 0, a.length - 1);
    }

    private static int[] sort(int a[], int lBound, int rBound) {
        if (lBound < rBound) {
            // Ищем середину массива
            int middle = lBound + (rBound - lBound) / 2;
            // Сортируем левую и правую половину
            sort(a, lBound, middle);
            sort(a, middle + 1, rBound);
            // Соединяем отсортированные половины
            merge(a, lBound, middle, rBound);
        }
        return a;
    }

    private static void merge(int a[], int lBound, int middle, int rBound) {
        // Вычисляем размеры соединяемых подмассивов
        int n1 = middle - lBound + 1;
        int n2 = rBound - middle;

        // Временные подмассивы
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Копируем данные во временные подмассивы
        for (int i = 0; i < n1; i++) {
            L[i] = a[lBound + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[middle + 1 + j];
        }
        // Теперь будем соединять временные массивы

        // Первоначальные индексы левого и правого массивов
        int i = 0;
        int j = 0;
        // Индекс результируемого массива
        int k = lBound;
        // Пока хотя бы один из подмассивов не кончился
        while (i < n1 && j < n2) {
            // Вставляем в результат меньший элемент из двух
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        // Копируем остатки из левого или правого подмассивов в результат
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
}

package structures;

/**
 *
 */
public class Heap {
    // хранилище элементов
    private int[] a;
    // Реальное кол-во элементов в хранилище
    private int heapSize;

    public Heap(int maxSize) {
        a = new int[maxSize];
        heapSize = 0;
    }

    public void add(int element) {
        heapSize++;
        a[heapSize - 1] = element;
        siftUp(heapSize - 1);
    }

    public int pullMinElement() {
        int min = a[0];
        // Ставим последний элемент вместо вершины
        a[0] = a[heapSize - 1];
        heapSize--;
        siftDown(0);
        return min;
    }

    // Просеивает кучу вниз (восстанавливает св-ва кучи при удалении вершины)
    private void siftDown(int i) {
        while (2 * i + 1 < heapSize) {
            int leftChildI = 2 * i + 1;
            int rightChildI = 2 * i + 2;
            // Менять местами будем с наименьшим дочерним элементом
            int j = (rightChildI < heapSize && a[rightChildI] < a[leftChildI]) ? rightChildI : leftChildI;
            // Если элемент меньше дочерних, останавливаемся
            if (a[i] <= a[j]) {
                break;
            }
            // Меняем местами с выбранным дочерним элементом
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            // Переходим к дочернему элементу (на уровень ниже)
            i = j;
        }
    }

    // Просеивает кучу вверх (восстанавливает св-ва кучи при добавлении вершины)
    private void siftUp(int i) {
        // Пока элемент меньше родителя
        while (a[i] < a[(i - 1) / 2]) {
            // Меняем их местами
            int temp = a[i];
            a[i] = a[(i - 1) / 2];
            a[(i - 1) / 2] = temp;
            // переходим к родительскому элементу (на уровень выше)
            i = (i - 1) / 2;
        }
    }
}

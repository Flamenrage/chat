package sortings.structure_based;

import structures.Tree;

/**
 *  Сортировка деревом
 *
 *  Использует бинарное дерево поиска.
 *  Элементы поочерёдно добавляются в дерево, а потом извлекаются обходом в отсортированном порядке
 *
 *  Время: луч. O(N * log(N))   худ. O(N^2)
 *  Память: O(N)
 *
 *  ВАЖНО! Может сортировать только массив уникальных элементов. Дубликаты сотрутся!
 */
public class TreeSort {

    public static int[] sort(int[] a) {
        Tree tree = new Tree();
        for (int elem: a) {
            tree.add(elem);
        }
        return tree.getElementsInOrder();
    }
}

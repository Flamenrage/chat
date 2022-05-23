package structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Бинарное дерево поиска
 *
 * Сложность всех операций:
 * в среднем O(log(N))
 * в худшем O(N)
 * Память: O(N)
 */
public class Tree {

    private Node root;
    private int nodesCount = 0;

    class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public void add(int element) {
        root = addRecursive(root, element);
        nodesCount++;
    }

    public boolean contains(int element) {
        return containsNodeRecursive(root, element);
    }

    /**
     * Обход в порядке возрастания значений
     * (левое поддерево — сам элемент — правое поддерево)
     */
    public void printInOrder() {
        traverseInOrder(root);
    }

    /**
     * Такой же обход в порядке возрастания значений, но итеративный
     * (левое поддерево — сам элемент — правое поддерево)
     * Этот метод используется в TreeSort
     */
    public int[] getElementsInOrder()
    {
        int[] result = new int[nodesCount];
        int resultI = 0;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr != null || s.size() > 0)
        {
            while (curr != null)
            {
                // Перед переходом к левому потомку добавляем текущую вершину в стек
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            result[resultI] = curr.data;
            resultI++;
            // переходим к правому поддереву
            curr = curr.right;
        }
        return result;
    }

    /**
     * Обход для копирования дерева
     * (сам элемент — левое поддерево — правое поддерево)
     */
    public void printPreOrder() {
        traversePreOrder(root);
    }

    /**
     * Обход для удаления дерева
     * (левое поддерево — правое поддерево — сам элемент)
     */
    public void printPostOrder() {
        traversePostOrder(root);
    }

    /**
     * Обход дерева в ширину (по горизонтали) (по уровням)
     */
    public void traverseBFS() {
        if (root == null) {
            return;
        }
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        while (!nodesQueue.isEmpty()) {
            // Удаляем текущий узел из очереди и печатаем
            Node node = nodesQueue.remove();
            System.out.print(" " + node.data);
            // Добавляем в очередь детей
            if (node.left != null) {
                nodesQueue.add(node.left);
            }
            if (node.right != null) {
                nodesQueue.add(node.right);
            }
        }
    }

    public void delete(int element) {
        root = deleteRecursive(root, element);
        nodesCount--;
    }

    private Node addRecursive(Node current, int element) {
        // Если дошли до края дерева, создаём узел
        if (current == null) {
            return new Node(element);
        }
        if (element < current.data) {
            // Идём к левому ребёнку
            current.left = addRecursive(current.left, element);
        } else if (element > current.data) {
            // Идём к правому ребёнку
            current.right = addRecursive(current.right, element);
        } else {
            // Такой элемент уже есть в дереве
            return current;
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, int element) {
        // Если дошли до края дерева, значит не нашли
        if (current == null) {
            return false;
        }
        // Если нашли искомый элемент
        if (element == current.data) {
            return true;
        }
        return (element < current.data) ?
                // Продолжаем поиск в левом/правом поддереве
                containsNodeRecursive(current.left, element) :
                containsNodeRecursive(current.right, element);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }


    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    private Node deleteRecursive(Node current, int element) {
        if (current == null) {
            return null;
        }
        // Если нашли элемент, который нужно удалить
        if (element == current.data) {
            // Если у элемента нет детей, просто возвращаем NULL вместо него
            if (current.left == null && current.right == null) {
                return null;
            }
            // Если у элемента 1 ребёнок, ставим ребёнка вместо текущего элемента
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Если у элемента 2 ребёнка, то нужно заменить его
            // либо на самый правый элемент левого поддерева,
            // либо на самый левый элемент правого поддерева.
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        // Если не нашли удаляемый элемент, ищем слева или справа
        if (element < current.data) {
            current.left = deleteRecursive(current.left, element);
            return current;
        } else {
            current.right = deleteRecursive(current.right, element);
            return current;
        }
    }

    // Ищет самый левый элемент дерева
    private int findSmallestValue(Node root) {
        return root.left == null ?
                root.data :
                findSmallestValue(root.left);
    }

}

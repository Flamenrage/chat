package structures;

/**
 * Сложность:
 * Вставка: O(N)
 * Поиск и удаление: O(N)
 */

public class LinkedList {

    private Node head;

    class Node {
        public int data;
        public Node next = null;
        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            // ищем хвост списка
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            // прицепляем новый элемент в конец
            last.next = newNode;
        }
    }

    public boolean contains(int data) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == data) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void printAll()
    {
        Node currNode = head;
        System.out.println();
        // пока не конец списка
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public void delete(int data) throws Exception {
        Node currNode = head;
        Node prev = null;
        // случай 1. Нужно удалить головной элемент
        if (currNode != null && currNode.data == data) {
            head = currNode.next;
            return;
        }
        // случай 2. удаляемый элемент - не головной
        // пока не нашли нужный или не дошли до конца
        while (currNode != null && currNode.data != data) {
            // идём дальше
            prev = currNode;
            currNode = currNode.next;
        }
        // если нашли
        if (currNode != null) {
            // удаляем
            prev.next = currNode.next;
            return;
        }
        // если не нашли
        if (currNode == null) {
            throw new Exception("Элемент не найден");
        }
    }
}

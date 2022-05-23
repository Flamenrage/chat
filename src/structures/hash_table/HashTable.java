package structures.hash_table;

/**
 * Хэш-таблица
 *
 * Сложность:
 * Время для всех операций: сред. O(1)   худ. O(N)
 * память: O(N)
 *
 */
public abstract class HashTable {
    protected Element[] a;
    // фактическое число элементов
    protected int count = 0;
    // размер таблицы
    protected int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        // инициализация пустой таблицы
        a = new Element[capacity];
        for (int i = 0; i < capacity; i++) {
            a[i] = new Element(0, null);
        }
    }

    public abstract void add(int key, String value) throws Exception;

    public abstract String getValue(int key);

    public abstract void delete(int key);

    public boolean contains(int key) {
        return getValue(key) != null;
    }

    public void printAll() {
        System.out.println();
        for (int i = 0; i < capacity; i++) {
            System.out.println(i + " | " + "(" + a[i].key + "; " + a[i].value + ")");
        }
    }

    protected int getHash(int key) {
        return (key % capacity);
    }
}

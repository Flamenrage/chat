package structures.hash_table;

public class DoubleHashTable extends HashTable {

    public DoubleHashTable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int key, String value) throws Exception {
        // Если мест нет
        if (count == capacity) {
            throw new Exception("Таблица переполнена");
        }
        int hash = hash1(key);
        // итерация пробирования
        int probIter = 0;
        // шаг пробирования
        int probStep = hash2(key);
        int i = hash + probIter * probStep;
        // Ищем свободную ячейку или ячейку, из которой ранее был удалён элемент
        while (a[i].value != null && (a[i] instanceof DeletedElement == false)) {
            probIter++;
            i = hash + probIter * probStep;
            // Если дошли до конца, переходим к началу таблицы
            i %= capacity;
        }
        a[i] = new Element(key, value);
        count++;
    }

    @Override
    public String getValue(int key) {
        int hash = hash1(key);
        int probIter = 0;
        int probStep = hash2(key);
        int i = hash + probIter * probStep;
        while (a[i].value != null) {
            // Если нашли, возвращаем результат
            if (a[i].key == key) {
                return a[i].value;
            }
            probIter++;
            i = hash + probIter * probStep;
            i %= capacity;
        }
        // Если пришли в пустую ячейку, элемент не найден
        return null;
    }

    @Override
    public void delete(int key) {
        int hash = hash1(key);
        // итерация пробирования
        int probIter = 0;
        int probStep = hash2(key);
        int i = hash + probIter * probStep;
        while (a[i].value != null) {
            // Если нашли, помечаем ячейку особым значением как удалённую
            // Это нужно для того, чтобы потом поиск не останавливался, а шёл
            // через неё дальше
            if (a[i].key == key) {
                a[i] = new DeletedElement();
                count--;
                return;
            }
            probIter++;
            i = hash + probIter * probStep;
            i %= capacity;
        }
    }

    private int hash1(int key) {
        return (key % capacity);
    }

    private int hash2(int key) {
        return (7 - (key % 7));
    }
}

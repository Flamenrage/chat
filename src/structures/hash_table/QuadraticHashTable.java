package structures.hash_table;

public class QuadraticHashTable extends HashTable {

    public QuadraticHashTable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int key, String value) throws Exception {
        // Если мест нет
        if (count == capacity) {
            throw new Exception("Таблица переполнена");
        }
        int hash = getHash(key);
        // итерация пробирования
        int probIter = 0;
        int i = hash + probIter * probIter;
        // Ищем свободную ячейку или ячейку, из которой ранее был удалён элемент
        while (a[i].value != null && (a[i] instanceof DeletedElement == false)) {
            probIter++;
            // Квадратичный шаг (0, 1, 4, 9, 16, ...)
            i = hash + probIter * probIter;
            // Если дошли до конца, переходим к началу таблицы
            i %= capacity;
        }
        a[i] = new Element(key, value);
        count++;
    }

    @Override
    public String getValue(int key) {
        int hash = getHash(key);
        int probIter = 0;
        int i = hash + probIter * probIter;
        while (a[i].value != null) {
            // Если нашли, возвращаем результат
            if (a[i].key == key) {
                return a[i].value;
            }
            probIter++;
            i = hash + probIter * probIter;
            i %= capacity;
        }
        // Если пришли в пустую ячейку, элемент не найден
        return null;
    }

    @Override
    public void delete(int key) {
        int hash = getHash(key);
        // итерация пробирования
        int probIter = 0;
        int i = hash + probIter * probIter;
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
            i = hash + probIter * probIter;
            i %= capacity;
        }
    }
}

package structures.hash_table;

public class LinearHashTable extends HashTable {

    public LinearHashTable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int key, String value) throws Exception {
        // Если мест нет
        if (count == capacity) {
            throw new Exception("Таблица переполнена");
        }
        int i = getHash(key);
        // Ищем свободную ячейку или ячейку, из которой ранее был удалён элемент
        while (a[i].value != null && (a[i] instanceof DeletedElement == false)) {
            i++;
            // Если дошли до конца, переходим к началу таблицы
            i %= capacity;
        }
        a[i] = new Element(key, value);
        count++;
    }

    @Override
    public String getValue(int key) {
        int i = getHash(key);
        int steps = 0;
        while (a[i].value != null) {
            // Если обошли всю таблицу и не нашли
            if (steps > capacity) {
                return null;
            }
            steps++;
            // Если нашли, возвращаем результат
            if (a[i].key == key) {
                return a[i].value;
            }
            i++;
            i %= capacity;
        }
        // Если пришли в пустую ячейку, элемент не найден
        return null;
    }

    @Override
    public void delete(int key) {
        int i = getHash(key);
        while (a[i].value != null) {
            // Если нашли, помечаем ячейку особым значением как удалённую
            // Это нужно для того, чтобы потом поиск не останавливался, а шёл
            // через неё дальше
            if (a[i].key == key) {
                a[i] = new DeletedElement();
                count--;
                return;
            }
            i++;
            i %= capacity;
        }
    }

}

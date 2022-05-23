package structures.hash_table;

import java.util.ArrayList;
import java.util.Iterator;

public class ChainHashTable {

    private ArrayList<Element>[] a;
    private int capacity;
    private int size;

    public ChainHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.a = new ArrayList[capacity];
        for (int i = 0; i < a.length; i++) {
            a[i] = new ArrayList(0);
        }
    }

    public void add(int key, String value) {
        int i = hashFunc(key);
        a[i].add(new Element(key, value));
        size++;
    }

    public boolean contains(int key) {
        return a[hashFunc(key)]
                .stream()
                .filter(element -> element.key == key)
                .count() > 0;
    }

    public String getValueByKey(int key) {
        return a[hashFunc(key)]
                .stream()
                .filter(element -> element.key == key)
                .findFirst()
                .get()
                .value;
    }

    public void delete(int key) {
        a[hashFunc(key)].removeIf(x -> x.key == key);
        size--;
    }

    public void rehash(int newCapacity) {
        Element[] copiedElements = new Element[size];
        int copyI = 0;
        for (ArrayList<Element> cell: a) {
            Iterator<Element> cellIterator = cell.iterator();
            while(cellIterator.hasNext()) {
                copiedElements[copyI++] = cellIterator.next();
            }
        }
        System.out.println("ALL ELEMENTS COPIED:  ");
        for (Element copy: copiedElements) {
            System.out.print(copy.value + " ");
        }
        this.capacity = newCapacity;
        this.size = 0;
        this.a = new ArrayList[newCapacity];
        for (int i = 0; i < a.length; i++) {
            a[i] = new ArrayList(0);
        }
        for (Element copy: copiedElements) {
            add(copy.key, copy.value);
        }
        System.out.println("FINISHED REHASH");
    }

    public void printSelf() {
        System.out.println();
        int index = 0;
        for (ArrayList<Element> cell: a) {
            System.out.println("--------------------------------------");
            System.out.println("CELL № " + index++);
            Iterator<Element> cellIterator = cell.iterator();
            while(cellIterator.hasNext()) {
                Element elem = cellIterator.next();
                System.out.print("(" + elem.key + ";" + elem.value + ") ");
            }
            System.out.println();
        }
    }

    private int hashFunc(int number) {
        return number % capacity;
    }
}


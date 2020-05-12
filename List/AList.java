/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.List;

import java.util.Arrays;

/**
 *
 * @author hp
 * @param <T>
 */
public final class AList<T> implements ListInterFace<T> {
     private T[] list;   // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public AList(int reqCapacty) {
        integrityOK = false;
        if (reqCapacty < DEFAULT_CAPACITY) {
            reqCapacty = DEFAULT_CAPACITY;
        } else {
            checkCapacity(reqCapacty);
            T[] result = (T[]) new Object[reqCapacty];
            list = result;
            numberOfEntries = 0;
            integrityOK = true;
        }

    }

    public void checkCapacity(int Capacity) {
        if (Capacity > MAX_CAPACITY) {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
    }

    public void chekintegrityOK() {
        if (!integrityOK) {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
    }

    @Override
    public void add(T newEntry) {
        chekintegrityOK();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();

    }

    private void ensureCapacity() {
        int capacity = list.length - 1; //لانه نبدأ من بوسشن رقم  1
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1); //هنا +1 لانه بدي ارجع لاري
        }
    }

    @Override
    public T remove(int index) {
        T result = null;
        if (index > 1 && index <= numberOfEntries + 1) {
            result = list[index];
            if (index < numberOfEntries) {  //يعني في حالة كان في المنتصف
                removeGap(index);
            }
            list[numberOfEntries] = null;  //للحالتين سواء اراد الاضافة من النهاية ام من المنتصف
            numberOfEntries--;

        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;
    }

    private void removeGap(int givenPosition) {
        int indexStart = givenPosition;
        for (int i = indexStart; i < numberOfEntries; i++) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public void clear() {
        int len = list.length;
        list = (T[]) new Object[len];
    }

    @Override
    public T set(int index, T anEntry) {
        T result = null;
        if (index < 1 && index <= numberOfEntries + 1) {
            result = list[index];
            list[index] = anEntry;
        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;
    }

    @Override
    public T get(int index) {
        T result = null;
        if (index < 1 && index <= numberOfEntries + 1) {
            result = list[index];
        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
        return result;

    }

    @Override
    public boolean contains(Object anEntry
    ) {
        chekintegrityOK();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
            index++;
        } // end while
        return found;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public void add(int index, T newEntry) {
        chekintegrityOK();
        // Assertion: The array list has room for another entry.
        if ((index >= 1) && (index <= numberOfEntries + 1)) {
            if (index <= numberOfEntries) {
                makeRoom(index);
            }
            list[index] = newEntry;   //في حالة الاضافة في النهاية وفي حالة الاضافة في المنتصف
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }

    }

    private void makeRoom(int givenPosition) {
        int firstIndex = numberOfEntries;
        int lastIndex = givenPosition;
        for (int i = firstIndex; i < lastIndex; i--) {
            list[i + 1] = list[i];
        }

    }
}

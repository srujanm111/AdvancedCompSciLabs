package Lab00_NumberList;

import java.util.Arrays;

public class NumberList<E> {

    private E[] list;
    private int size;

    public NumberList() {
        list = (E[])new Object[2];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E value) {
        add(size, value);
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index: " + index);
        if (list[list.length-1] != null) doubleCapacity();

        for (int i = index; i < list.length; i++) {
            E temp = list[i];
            list[i] = value;
            value = temp;
            if (value == null) break;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index: " + index);
        return list[index];
    }

    public E set(int index, E value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index: " + index);
        E replaced = list[index];
        list[index] = value;
        return replaced;
    }

    public E remove(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index: " + index);
        E removed = list[index];
        for(int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String toString = "[";
        for (int i = 0; i < size; i++) {
            toString += list[i].toString() + ", ";
        }
        return toString.substring(0, toString.length()-2) + "]";
    }

    private void doubleCapacity() {
        E[] newArray = (E[]) new Object[list.length*2];
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) break;
            newArray[i] = list[i];
        }
        list = newArray;
    }
}

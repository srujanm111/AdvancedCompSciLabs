package Lab02_MyStack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {

    Integer[] stack;
    int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int initCap) {
        stack = new Integer[initCap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (size == 0) throw new EmptyStackException();
        return stack[size - 1];
    }

    public Integer pop() {
        if (size == 0) throw new EmptyStackException();
        int num = stack[size - 1];
        size--;
        return num;
    }

    public void push(Integer item) {
        if (size == stack.length) doubleCapacity();
        stack[size] = item;
        size++;
    }

    private void doubleCapacity() {
        Integer[] newStack = new Integer[stack.length*2];
        for (int i = 0; i < stack.length; i++) newStack[i] = stack[i];
        stack = newStack;
    }

    @Override
    public String toString() {
        if (stack.length == 0) return "[]";
        String s = "[";
        for (Integer i : stack) {
            if (i == null) break;
            s += i + ", ";
        }
        return s.substring(0, s.length()-2) + "]";
    }

    public int getSize() {
        return size;
    }
}

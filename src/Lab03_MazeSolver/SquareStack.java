package Lab03_MazeSolver;

import java.util.EmptyStackException;

public class SquareStack implements StackADT {

    Square[] stack;
    int size;

    public SquareStack() {
        this(10);
    }

    public SquareStack(int initCap) {
        stack = new Square[initCap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Square peek() {
        if (size == 0) throw new EmptyStackException();
        return stack[size - 1];
    }

    public Square pop() {
        if (size == 0) throw new EmptyStackException();
        Square num = stack[size - 1];
        size--;
        return num;
    }

    public void push(Square item) {
        if (size == stack.length) doubleCapacity();
        stack[size] = item;
        size++;
    }

    private void doubleCapacity() {
        Square[] newStack = new Square[stack.length*2];
        for (int i = 0; i < stack.length; i++) newStack[i] = stack[i];
        stack = newStack;
    }

    @Override
    public String toString() {
        if (stack.length == 0) return "[]";
        String s = "[";
        for (Square i : stack) {
            if (i == null) break;
            s += i + ", ";
        }
        return s.substring(0, s.length()-2) + "]";
    }

    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) return;
            stack[i] = null;
        }
        size = 0;
    }
}

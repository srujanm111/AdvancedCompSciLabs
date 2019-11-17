package Lab16_MinHeap;

public class MinHeap {

    Integer[] heap;
    int size;
    static final int DEFAULT_CAPACITY = 8;

    public MinHeap() {
        this.heap = new Integer[DEFAULT_CAPACITY + 1];
    }

    public MinHeap(Integer... supplied) {
        size = supplied.length;
        int fullSize = 1;
        int add = 2;
        while (fullSize < size) {
            fullSize += add;
            add *= 2;
        }
        heap = new Integer[fullSize];
        for (int i = 0; i < supplied.length; i++)
            heap[i + 1] = supplied[i];
        for (int parentIndex = getParentIndex(size); parentIndex >= 1; parentIndex--) {
            siftDown(parentIndex);
        }
    }

    public void insert(int num) {
        if (size == heap.length - 1) doubleCapacity();
        int newIndex = size + 1;
        heap[newIndex] = num;
        bubbleUp(newIndex);
        size++;
    }

    public int popMinimum() {
        int popped = peekMinimum();
        int last = heap[size];
        heap[size] = null;
        size--;
        heap[1] = last;
        siftDown(1);
        return popped;
    }

    public int peekMinimum() {
        return heap[1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private void doubleCapacity() {
        Integer[] newArray = new Integer[heap.length * 2];
        for (int i = 1; i < heap.length; i++) {
            newArray[i] = heap[i];
        }
        heap = newArray;
    }

    private void bubbleUp(int index) {
        if (heap[getParentIndex(index)] == null) return;
        if (heap[index] < heap[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            bubbleUp(getParentIndex(index));
        }
    }

    private void siftDown(int index) {
        if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] == null) return;
        if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] == null) {
            if (heap[index] > heap[getLeftChildIndex(index)])
                swap(index, getLeftChildIndex(index));
            return;
        } else if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] != null) {
            if (heap[index] > heap[getRightChildIndex(index)])
                swap(index, getRightChildIndex(index));
            return;
        }
        if (heap[index] > Math.min(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)])) {
            int swapIndex = heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)] ? getLeftChildIndex(index) : getRightChildIndex(index);
            swap(index, swapIndex);
            siftDown(swapIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index2];
        heap[index2] = heap[index1];
        heap[index1] = temp;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 1; i <= getSize(); i++)
            output += heap[i] + ", ";
        return output.substring(0, output.lastIndexOf(","));
    }

    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j <= this.getSize()) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print((heap[j] == null) ? "" : heap[j]);
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
            j++;
        }
        System.out.println("\n" + dots + dots);
    }
}

package Lab08_LinkedListQueue;

import Lab07_MyLinkedList.MyLinkedList;

public class MyQueue<T> implements QueueADT<T> {

    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public MyQueue(T... vals) {
        queue = new MyLinkedList<>(vals);
    }

    @Override
    public void offer(T item) {
        queue.add(item);
    }

    @Override
    public T poll() {
        T item = queue.get(0);
        queue.remove(0);
        return item;
    }

    @Override
    public T peek() {
        return queue.get(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        for (int i = 0; i < queue.size(); i++) {
            queue.remove(0);
        }
    }
}

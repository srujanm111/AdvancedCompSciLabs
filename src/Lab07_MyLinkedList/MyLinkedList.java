package Lab07_MyLinkedList;

public class MyLinkedList<E> {

    ListNode head, tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public MyLinkedList(E... vals) {
        for (E val : vals) {
            add(val);
        }
    }

    public MyLinkedList(E val) {
        this.head = this.tail = new ListNode(val);
        size = 1;
    }

    public void add(E newVal) {
        if (head == null) {
            tail = head = new ListNode(newVal);
            size++;
            return;
        }
        tail.next = new ListNode(newVal);
        tail = tail.next;
        size++;
    }

    public boolean contains(E target) {
        ListNode next = head;
        while (next != null) {
            if (next.val.equals(target)) return true;
            next = next.next;
        }
        return false;
    }

    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        ListNode next = head;
        for (int i = 0; i < index; i++) next = next.next;
        return next.val;
    }

    public int indexOf(E target) {
        ListNode next = head;
        int index = 0;
        while (next != null) {
            if (next.val.equals(target)) return index;
            index++;
            next = next.next;
        }
        return -1;
    }

    public void set(E newVal, int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        ListNode next = head;
        for (int i = 0; i < index; i++) next = next.next;
        next.val = newVal;
    }

    public int size() {
        return size;
    }

    public int sizeRecursive(ListNode node) {
        if (node == null) return 0;
        return 1 + sizeRecursive(node.next);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (isEmpty() || index >= size) throw new IndexOutOfBoundsException();
        ListNode node = head, prev = null;
        if (index == 0) {
            E val = head.val;
            head = head.next;
            size--;
            return val;
        }
        for (int i = 0; i < index; i++) {
            prev = node;
            node = node.next;
        }
        E val = node.val;
        if (tail == node) tail = prev;
        prev.next = node.next;
        size--;
        return val;
    }

    public void add(E newVal, int index) {
        if (index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            add(newVal);
            return;
        }
        ListNode node = head, prev = null;
        if (index == 0) {
            ListNode n = new ListNode(newVal);
            n.next = head;
            head = n;
            return;
        }
        for (int i = 0; i < index; i++) {
            prev = node;
            node = node.next;
        }
        ListNode n = new ListNode(newVal);
        n.next = node;
        prev.next = n;
        size++;
    }

    @Override
    public String toString() {
        if (size() == 0) return "[]";
        StringBuffer toString = new StringBuffer("[");
        ListNode node = head;
        while (node != null) {
            toString.append(node.val + ", ");
            node = node.next;
        }
        return toString.substring(0, toString.lastIndexOf(",")) + "]";
    }

    public boolean detectCycle() {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (slow == null || fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
    }

    private class ListNode {
        E val;
        ListNode next;

        public ListNode(E val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

}

package Quizzes;

import java.util.*;

public class MyLinkedList {
    public static final int ID = 226216; //add your student ID here

    private ListNode front;

    public class ListNode //******** INNER CLASS ********
    {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + this.data;
        }
    }

    public MyLinkedList() //not actually necessary but included for clarity
    {
        front = null;
    }

    public MyLinkedList(int val) {
        front = new ListNode(val);
    }

    /**
     * for ease of testing, you can construct a MLL object with initial values:
     * MyLinkedList list = new MyLinkedList(1, 2, 3, 4);
     */
    public MyLinkedList(int... vals) {
        if (front == null) front = new ListNode(vals[0]);

        ListNode current = front;

        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        String result = "[";

        ListNode current = front;

        while (current != null) {
            if (current.next == null) //reached last element in the list
                result += current.data;

            else
                result += current.data + ", ";

            current = current.next;
        }
        result += "]";

        return result;
    }

    public ListNode getFront() {
        return this.front;
    }

    /********************************************
     ********** QUIZ METHODS BELOW HERE *********
     ********************************************/

    //#1
    public void replaceLast(int n) {
        if (front.next == null) {
            front.data = n;
            return;
        }
        ListNode node = front;
        while (node.next != null) {
            node = node.next;
        }
        node.data = n;
    }

    //#2
    public int lastIndexOf(int val) {
        int index = -1;
        ListNode node = front;
        int i = 0;
        while (node != null) {
            if (node.data == val) {
                index = i;
            }
            i++;
            node = node.next;
        }

        return index;
    }

    //#3
    public int countDuplicates() {
        HashMap<Integer, Integer> counts = new HashMap<>();
        ListNode node = front;
        while (node != null) {
            if (counts.containsKey(node.data)) {
                counts.put(node.data, counts.get(node.data) + 1);
            } else {
                counts.put(node.data, 0);
            }
            node = node.next;
        }
        int sum = 0;
        for (int value : counts.values()) {
            sum += value;
        }
        return sum;
    }

    //#4
    public void stutter() {
        ListNode node = front;
        while (node != null) {
            ListNode temp = node.next;
            node.next = new ListNode(node.data);
            node.next.next = temp;
            node = node.next.next;
        }
    }

    //#5
    public void removeAll(int n) {
        while (front != null && front.data == n) {
            front = front.next;
        }
        ListNode node = front;
        while (node != null && node.next != null) {
            if (node.next.data == n) {
                node.next = node.next.next;
            }
            node = node.next;
        }
    }

    //#6
    public int deleteLast() {
        if (front.next == null) {
            int d = front.data;
            front = null;
            return d;
        } else if (front.next.next == null) {
            int d = front.next.data;
            front.next = null;
            return d;
        }

        ListNode node = front;
        while (node.next.next != null) {
            node = node.next;
        }

        int d = node.next.data;
        node.next = null;
        return d;
    }

    /**
     * You can test your methods below if you'd like
     */
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(17, 2, 5);
        System.out.println(linkedList.deleteLast());
        System.out.println(linkedList);
    }
}
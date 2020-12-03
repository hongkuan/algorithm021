package com.tj.kuan;

public class MinStack {
    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if (null == head) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        private int val;
        private int min;
        private Node next;

        private Node(int val, int min) {
            this.val = val;
            this.min = min;
            next = null;
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

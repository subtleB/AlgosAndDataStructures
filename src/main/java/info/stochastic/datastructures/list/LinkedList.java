package main.java.info.stochastic.datastructures.list;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        Node(T item) {
            this.item = item;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    int size = 0;

    public LinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(T item) {
        insertBefore(head.next, new Node<>(item));
    }

    public void addLast(T item) {
        insertBefore(tail, new Node<>(item));
    }

    public T removeFirst() {
        return remove(head.next);
    }

    public T removeLast() {
        return remove(tail.prev);
    }

    public T getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return head.next.item;
    }

    public T getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return tail.prev.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void insertBefore(Node<T> pivot, Node<T> node) {
        node.prev = pivot.prev;
        node.next = pivot;
        pivot.prev.next = node;
        pivot.prev = node;
        size++;
    }

    private T remove(Node<T> node) {
        if (size == 0)
            throw new NoSuchElementException();
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        T item = node.item;
        node = node.next = node.prev = null;
        return item;
    }

}

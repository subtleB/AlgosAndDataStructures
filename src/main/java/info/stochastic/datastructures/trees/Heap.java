package main.java.info.stochastic.datastructures.trees;

import java.util.*;

public class Heap<T> {

    private static final int INIT_CAPACITY = 11;

    private Comparator<? super T> comparator;

    private Object[] elements;

    private int size = 0;

    public Heap(Comparator<T> comparator) {
        if (comparator == null) {
            throw new NullPointerException();
        }

        this.comparator = comparator;
        this.elements = new Object[INIT_CAPACITY];
    }

    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        int position = size++;
        if (position >= elements.length) {
            grow(position);
        }
        shiftUp(position, element);
    }

    @SuppressWarnings("unchecked")
    private void shiftUp(int position, T element) {
        while (position > 0) {
            int parent = (position - 1) >>> 1;
            if (comparator.compare(element, (T) elements[parent]) >= 0) {
                break;
            }
            elements[position] = elements[parent];
            position = parent;
        }
        elements[position] = element;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return size == 0 ? null : (T) elements[0];
    }

    private void grow(int size) {
        int newCapacity = elements.length + size;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) {
            return null;
        }

        int last = --size;
        T top = (T) elements[0];
        T lastElem = (T) elements[last];
        elements[last] = null;
        if (last != 0) {
            shiftDown(lastElem);
        }

        return top;
    }

    @SuppressWarnings("unchecked")
    private void shiftDown(T element) {
        int half = size >>> 1;
        int position = 0;

        // position >= half means it is a leaf
        while (position < half) {
            int childIndex = (position << 1) + 1;
            Object child = elements[childIndex];
            if (childIndex + 1 < size
                    && comparator.compare((T) child, (T) elements[childIndex + 1]) > 0) {
                childIndex = childIndex + 1;
                child =  elements[childIndex];
            }

            if (comparator.compare(element, (T) child) <= 0) {
                break;
            }
            elements[position] = elements[childIndex];
            position = childIndex;
        }
        elements[position] = element;
    }
}











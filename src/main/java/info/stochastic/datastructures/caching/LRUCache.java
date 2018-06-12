package main.java.info.stochastic.datastructures.caching;

import java.util.*;

class LRUCache {

    private class LRULinkedListItem {
        LRULinkedListItem next;
        LRULinkedListItem prev;
        int key;
        int value;

        LRULinkedListItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LRULinkedListItem head;
    private LRULinkedListItem tail;

    private Map<Integer, LRULinkedListItem> lruMap;

    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.lruMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (!lruMap.containsKey(key)) {
            return -1;
        }
        LRULinkedListItem item = lruMap.get(key);
        updateItemPosition(item);
        return item.value;
    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            LRULinkedListItem item = lruMap.get(key);
            updateItemPosition(item, value);
            return;
        }

        // Erase least recently used element if needed
        assert (size <= capacity);
        if (size == capacity) {

            LRULinkedListItem oldHead = head;
            head = head.next;

            if (head != null) {
                head.prev = null;
            }

            oldHead.next = null;
            lruMap.remove(oldHead.key);
        } else {
            size++;
        }

        // Add an item
        LRULinkedListItem newItem = new LRULinkedListItem(key, value);
        lruMap.put(key, newItem);

        if (size == 1) {
            head = newItem;
            tail = newItem;
            return;
        }

        tail.next = newItem;
        newItem.prev = tail;
        newItem.next = null;
        tail = newItem;
    }

    private void updateItemPosition(LRULinkedListItem item) {
        updateItemPosition(item, item.value);
    }

    private void updateItemPosition(LRULinkedListItem item, int value) {

        // Update it's value
        item.value = value;

        // Nothing to do with the rightmost element
        if (item == tail) {
            return;
        }

        LRULinkedListItem prev = item.prev;
        LRULinkedListItem next = item.next;

        // Add it to the tail
        tail.next = item;
        item.prev = tail;
        item.next = null;
        tail = item;

        // Leftmost item
        if (item == head) {
            next.prev = null;
            head = next;

        // Item is somewhere in the middle
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }


    public static void main(String[] args) {
        //[1],[2,1],[2],[3,2],[2],[3]
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        //cache.put(3, 3);
        //[1,1],[2,2],[1],[3,3],[2]
    }
}



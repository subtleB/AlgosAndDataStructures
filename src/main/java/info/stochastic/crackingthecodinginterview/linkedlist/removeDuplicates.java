package main.java.info.stochastic.crackingthecodinginterview.linkedlist;

public class removeDuplicates {

    static void removeDuplicates(SingleLinkedList list, int data) {
        SingleLinkedList prev = list;
        SingleLinkedList cur = list.next;
        while (cur != null) {
            if (cur.data == data) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
    }

    static void removeDuplicates(SingleLinkedList list) {
        while (list != null) {
            removeDuplicates(list, list.data);
            list = list.next;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 3, 4, 5, 3, 6, 6, 3, 3, 1, 3, 5, 6, 3, 4, 3};
        SingleLinkedList head = SingleLinkedList.init(a);
        removeDuplicates(head);
        SingleLinkedList.print(head);
    }
}

package main.java.info.stochastic.crackingthecodinginterview.linkedlist;

public class SingleLinkedList {
    SingleLinkedList next;
    int data;

    static SingleLinkedList init(int[] a) {
        SingleLinkedList head = new SingleLinkedList();
        SingleLinkedList list = head;
        for (int i = 0; i < a.length; i++) {
            list.data = a[i];
            if (i == a.length - 1) {
                break;
            }
            list.next = new SingleLinkedList();
            list = list.next;
        }
        return head;
    }

    static void print(SingleLinkedList list) {
        SingleLinkedList head = list;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

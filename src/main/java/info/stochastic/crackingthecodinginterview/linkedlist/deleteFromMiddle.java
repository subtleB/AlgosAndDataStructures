package main.java.info.stochastic.crackingthecodinginterview.linkedlist;

public class deleteFromMiddle {

    static void swap(SingleLinkedList e1, SingleLinkedList e2) {
        int tmp = e1.data;
        e1.data = e2.data;
        e2.data = tmp;
    }

    static void delete(SingleLinkedList elem) {
        SingleLinkedList prev = elem;
        elem = elem.next;
        while (elem.next != null) {
            swap(elem, prev);
            prev = elem;
            elem = elem.next;
        }
        swap(elem, prev);
        prev.next = null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        SingleLinkedList head = SingleLinkedList.init(a);
        SingleLinkedList list = head;
        list = list.next;
        list = list.next;
        delete(list);
        SingleLinkedList.print(head);
    }
}

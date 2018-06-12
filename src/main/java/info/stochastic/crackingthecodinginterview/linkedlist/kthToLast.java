package main.java.info.stochastic.crackingthecodinginterview.linkedlist;

public class kthToLast {

    static SingleLinkedList kthToLast(SingleLinkedList list, int k) {
        SingleLinkedList first = list;
        SingleLinkedList second = list;
        while (first.next != null && k > 0) {
            first = first.next;
            k--;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 3, 4, 5, 3, 6, 6, 3, 3, 1, 3, 5, 6, 3, 4, 7};
        SingleLinkedList head = SingleLinkedList.init(a);
        SingleLinkedList kth = kthToLast(head, 1);
        System.out.println(kth.data);
    }
}

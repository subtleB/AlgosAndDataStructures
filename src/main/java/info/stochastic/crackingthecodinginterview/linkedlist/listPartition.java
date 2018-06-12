package main.java.info.stochastic.crackingthecodinginterview.linkedlist;

public class listPartition {

    static SingleLinkedList makePartition(SingleLinkedList list, int value) {
        SingleLinkedList head = list;
        SingleLinkedList prev = list;
        SingleLinkedList cur = list.next;

        while (cur != null) {
            if (cur.data == value && cur != head) {
                // append to head
                prev.next = cur.next;
                cur.next = head;
                head = cur;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        prev = head;
        cur = head.next;
        while (cur != null) {
            if (cur.data < value && cur != head) {
                // append to head
                prev.next = cur.next;
                cur.next = head;
                head = cur;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 2, 3, 4, 5, 10, 3, 10, 1, 99, 32, 10, 2, 43};
        SingleLinkedList head = SingleLinkedList.init(a);
        SingleLinkedList result = makePartition(head, 43);
        SingleLinkedList.print(result);
    }
}

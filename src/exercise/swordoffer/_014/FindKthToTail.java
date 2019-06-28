package exercise.swordoffer._014;

import exercise.swordoffer._03.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode head2 = head;
        int count = 1;
        int count2 = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        if (k > count) {
            return null;
        }
        if (count == k) {
            return head2;
        }
        while (head2.next != null) {
            count2 ++;
            head2 = head2.next;
            if (count2 == (count - k + 1)) {
                return head2;
            }
        }
        return null;
    }

    public static ListNode findKthToTail2(ListNode list,int k) {
        if (list == null) {
            return list;
        }

        ListNode node = list;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        if (count < k){
            return null;
        }

        ListNode p = list;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(findKthToTail(head, 100).val);
        System.out.println(findKthToTail2(head, 100).val);


    }
}


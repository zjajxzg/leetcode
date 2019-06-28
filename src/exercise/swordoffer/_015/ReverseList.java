package exercise.swordoffer._015;

import exercise.swordoffer._03.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        while (head.next != null) {
//            head = head.next;
//        }

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(reverseList(head));
    }
}

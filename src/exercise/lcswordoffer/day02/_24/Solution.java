package exercise.lcswordoffer.day02._24;

import common.ListNode;

/**
 * 反转链表
 *
 * @author xuzhigang
 * @date 2022/4/8 7:43 上午
 **/
public class Solution {
    public ListNode reverseList1(ListNode head) {
        // 新的头节点
        ListNode prev = null;
        // 当前节点
        ListNode curr = head;
        while (curr != null) {
            // 保存下一个节点
            ListNode next = curr.next;
            // 翻转两个节点
            curr.next = prev;
            prev = curr;
            // 继续
            curr = next;
        }
        return prev;
    }

    /**
     * 递归版本
     * 1. 大问题拆成两个子问题
     * 2. 子问题求解方式和大问题一样
     * 3. 存在最小子问题
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

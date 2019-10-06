package exercise.swordoffer._018;

import exercise.swordoffer._03.ListNode;

import java.util.HashSet;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author zhigang.xu
 * @date 2019/10/4 9:45
 */
public class Solution {
    /**
     *
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            if (last.next != null && (last.val == last.next.val)) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;

    }

    /**
     * 递归解
     *
     * @param phead
     * @return
     */
    public static ListNode deleteDuplication2(ListNode phead) {
        // 终止条件
        if (phead == null || phead.next == null) {
            return phead;
        }

        if (phead.val == phead.next.val) {
            ListNode node = phead.next;
            // 头结点重复 跳过
            while (node !=null && node.val == phead.val) {
                node = node.next;
            }
            return deleteDuplication2(node);
        } else {
            phead.next = deleteDuplication2(phead.next);
            return phead;
        }
    }

    public static void main(String[] args) {
        ListNode phead = new ListNode(1);
        phead.next = new ListNode(2);
        phead.next.next = new ListNode(3);
        phead.next.next.next = new ListNode(3);
        phead.next.next.next.next = new ListNode(4);
        phead.next.next.next.next.next = new ListNode(4);
        phead.next.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteDuplication(phead));
//        System.out.println(deleteDuplication2(phead));
    }
}

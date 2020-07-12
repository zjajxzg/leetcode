package exercise.tag.linkedlist._206;

import exercise.structure.ListNode;

import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhigang.xu
 */
public class Solution {
    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录下一个节点
            ListNode temp = curr.next;
            // 下一个节点指向prev
            curr.next = prev;
            // prev指向新节点
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 递归
     * 只有一个节点  直接返回
     * 两个节点 下一个节点指向前一个节点 前一个节点指向null 避免出现循环链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        System.out.println(reverseList1(head));
        System.out.println(reverseList2(head));
    }
}

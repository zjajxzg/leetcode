package exercise.lcswordoffer.day02._06;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author xuzhigang
 * @date 2022/4/7 8:40 上午
 **/
public class Solution {
    public int[] reversePrint(ListNode head) {
        // 借助栈实现
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int[] arr = new int[deque.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = deque.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        Solution solution = new Solution();
        int[] arr = solution.reversePrint(head);
    }
}

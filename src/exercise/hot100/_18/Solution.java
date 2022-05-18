package exercise.hot100._18;

import common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author xuzhigang
 * @date 2022/5/18 8:32 上午
 **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode node = head;

        // 算出链表长度
        int length = 1;
        while (head != null) {
            head = head.next;
            length++;
        }
        // 计算倒数第n个是正数第几个
        int m = length - n + 1;

        ListNode temp = node;
        if (m == 1) {
            return node.next;
        }
        int i = 2;
        while (node != null) {
            if (i == m - 1) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
            i++;
        }
        return temp;
    }


    // 在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），它的next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。
    // 双指针 快慢指针 当一个指针遍历到n了，另一个指针开始遍历，遍历完了就到了倒数第n个节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        int i = 1;
        while (first != null) {
            if (i > n) {
                second = second.next;
            }
            first = first.next;
            i++;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

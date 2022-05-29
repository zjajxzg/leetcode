package exercise.hot100._234;

import common.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 通过次数440,060提交次数852,084
 *
 * @author xuzhigang
 * @date 2022/5/29 3:50 下午
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {

        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                return true;
            }
            Integer pop = deque.removeFirst();
            Integer poll = deque.removeLast();
            if (!Objects.equals(poll, pop)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        // 前后指针
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int pre = 0;
        int next = list.size() - 1;
        while (pre <= next) {
            if (!Objects.equals(list.get(pre), list.get(next))) {
                return false;
            }
            pre++;
            next--;
        }
        return true;
    }
}

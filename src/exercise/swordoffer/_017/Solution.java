package exercise.swordoffer._017;

import exercise.swordoffer._03.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author zhigang.xu
 * @date 2019/10/3 10:40
 */
public class Solution {
    /**
     * 思路1  遍历链表存入set  出现重复则说明是入口结点
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set set = new HashSet();
        while (pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 思路2 快慢指针
     * 利用快慢指针判断是否有环 快指针每次走2步  慢指针每次走1步  能够相遇说明有环
     * 相遇后将快指针放回链表头结点  两个指针同时开始1步1步走  再次相遇点即为入口结点
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                break;
            }
        }
        if (pFast == null || pFast.next == null) {
            return null;
        }
        pFast = pHead;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }
}

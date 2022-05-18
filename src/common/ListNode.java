package common;

/**
 * 链表节点
 *
 * @author xuzhigang
 * @date 2021/11/2 8:34 上午
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

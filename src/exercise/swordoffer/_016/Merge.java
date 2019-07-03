package exercise.swordoffer._016;

import exercise.swordoffer._03.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else{
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * TODO
     */
    public static ListNode merge2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode list = new ListNode(list1.val < list2.val ? list1.val : list2.val);
        while (list1.next != null && list2.next != null) {
            if (list1.next.val <= list2.next.val) {
                 list.next = list1.next;
                 list1 = list1.next.next;
            } else {
                list.next = list2.next;
                list2 = list2.next.next;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        System.out.println(merge(list1, list2));
        System.out.println(merge2(list1, list2));
    }
}

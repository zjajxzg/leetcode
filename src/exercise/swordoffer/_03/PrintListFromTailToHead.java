package exercise.swordoffer._03;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author zhigang.xu
 */
public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        if (listNode == null) {
            return arrayList;
        }
        arrayList.add(listNode.val);
        while (listNode.next != null) {
            arrayList.add(listNode.next.val);
            listNode = listNode.next;
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode = null;
        System.out.println(printListFromTailToHead(listNode));
    }
}

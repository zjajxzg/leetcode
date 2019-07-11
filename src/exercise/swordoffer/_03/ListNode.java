package exercise.swordoffer._03;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        while (this.next != null) {
            sb.append(new StringBuilder(String.valueOf(this.val)));
            this.next = this.next.next;
        }
        return sb.toString();
    }
}

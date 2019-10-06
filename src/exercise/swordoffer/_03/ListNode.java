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
        sb.append(val);
        while (this.next != null) {
            sb.append(",").append(new StringBuilder(String.valueOf(this.next.val)));
            this.next = this.next.next;
        }
        return sb.toString();
    }
}

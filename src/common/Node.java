package common;

/**
 * @author xuzhigang
 * @date 2022/4/8 10:22 下午
 **/
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

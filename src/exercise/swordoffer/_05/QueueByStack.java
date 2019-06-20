package exercise.swordoffer._05;

import java.util.Stack;

/**
 * TODO
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        stack2.push(stack1.peek());
    }

    public int pop() {
        return stack2.pop();
    }
}

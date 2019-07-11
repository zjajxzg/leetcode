package exercise.tag.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {

    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if (list.size() <= 0) {
            throw new IllegalArgumentException("empty");
        }
        list.remove(list.size() - 1);
    }

    public int top() {
        if (list.size() <= 0) {
            throw new IllegalArgumentException("empty");
        }
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        int min = list.get(0);
        for (int i = 1; i <= list.size() - 1; i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
}

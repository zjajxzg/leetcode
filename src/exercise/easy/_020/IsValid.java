package exercise.easy._020;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    /**
     * 利用栈先进后出的特点解题
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // 遍历字符串   先入栈  如果栈顶的括号与新入的括号相对应 则出栈 最后stack为空说明字符串是符合要求的
        for (char c : chars) {
            if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 取巧的方法 效率比较低
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }

        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("({})"));
    }
}

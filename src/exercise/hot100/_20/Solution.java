package exercise.hot100._20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuzhigang
 * @date 2022/4/5 6:18 下午
 **/
public class Solution {
    public boolean isValid(String s) {
        // 不是偶数肯定不对称
        if (s.length() % 2 == 1) {
            return false;
        }
        // 构造对应关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        // 利用栈的先进后出的特性 push
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            Character character = map.get(c);
            if (null == character) {
                deque.push(c);
                continue;
            }
            Character peek = deque.peek();
            if (Objects.equals(peek, character)) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();


    }
}

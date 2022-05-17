package exercise.hot100._17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author xuzhigang
 * @date 2022/5/17 11:21 上午
 **/
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            queueLetterCombinations(queue, map.get(digits.charAt(i)));
        }

        return new ArrayList<>(queue);
    }

    /**
     * 借助队列实现 类似于树的层序遍历
     * @param queue
     * @param strArr
     * @return
     */
    private Queue<String> queueLetterCombinations(Queue<String> queue, String[] strArr) {
        // 首次进来 queue为空 将第一组字母添加进queue
        if (queue.size() == 0) {
            queue.addAll(Arrays.asList(strArr));
        } else {
            // queue不为空，说明已经添加过一组
            // 将queue的元素取出，拼上字母再放回queue
            // 仅取出队列中当前长度的元素 先取出长度 否则会导致死循环
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                // 字母数组的每个字母都需要拼一遍 放回队列
                for (String s : strArr) {
                    queue.add(poll + s);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    /**
     * 回溯
     */
//    public List<String> letterCombinations(String digits) {
//        List<String> combinations = new ArrayList<String>();
//        if (digits.length() == 0) {
//            return combinations;
//        }
//        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
//            put('2', "abc");
//            put('3', "def");
//            put('4', "ghi");
//            put('5', "jkl");
//            put('6', "mno");
//            put('7', "pqrs");
//            put('8', "tuv");
//            put('9', "wxyz");
//        }};
//        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
//        return combinations;
//    }
//
//    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
//        if (index == digits.length()) {
//            combinations.add(combination.toString());
//        } else {
//            char digit = digits.charAt(index);
//            String letters = phoneMap.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                combination.append(letters.charAt(i));
//                backtrack(combinations, phoneMap, digits, index + 1, combination);
//                combination.deleteCharAt(index);
//            }
//        }
//    }
}

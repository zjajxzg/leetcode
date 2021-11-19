package exercise.medium._003;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuzhigang
 * @date 2021/11/18 8:47 下午
 **/
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        int left = 0;
        // key: 字符 value: index
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 已存在
            Integer index = map.get(c);
            if (Objects.nonNull(index)) {
                left = Math.max(index + 1, left);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }

    /**
     * 滑动窗口  双指针的思路
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        // 结果
        int max = 0;
        // 左指针
        int left = 0;
        // key: 字符 value: index
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null) {
                // 出现重复 左指针后移 重复的索引与当前左指针比较大小
                left = Math.max(index + 1, left);
            }
            // 没有重复 当前窗口-左指针
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }

        public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("dvdf"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("abba"));
        }
}

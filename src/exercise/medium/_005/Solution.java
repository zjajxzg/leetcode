package exercise.medium._005;

import java.util.Objects;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author xuzhigang
 * @date 2021/11/19 9:42 下午
 **/
public class Solution {
    /**
     * 从中心向外扩展，最长回文串就是最外一层
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = palindrome(s, i, i);
            String palindrome1 = palindrome(s, i, i + 1);
            ans = ans.length() >= palindrome.length() ? ans : palindrome;
            ans = ans.length() >= palindrome1.length() ? ans : palindrome1;
        }

        return ans;
    }

    /**
     * 指定字符串 指定位置的最长回文串
     * 考虑奇偶 需要传两个索引
     *
     * @param s
     * @param l
     * @param r
     * @return
     */
    private static String palindrome(String s, int l, int r) {
        // 左右指针始终相等
        while (l >= 0 && r < s.length() && Objects.equals(s.charAt(l), s.charAt(r))) {
            // 左指针向左移动
            l--;
            // 右指针向右移动
            r++;
        }
        // 循环之后得到最大回文串 左开右闭
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcd"));
//        System.out.println("ac".substring(1, 1));
    }
}

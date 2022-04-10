package exercise.lcswordoffer.day03._058;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 * 
 * @author xuzhigang
 * @date 2022/4/10 8:42 下午
 **/
public class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || n <= 0) {
            return s;
        }
        StringBuilder pre = new StringBuilder();
        StringBuilder end = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                pre.append(s.charAt(i));
                continue;
            }
            end.append(s.charAt(i));

        }
        return end.append(pre).toString();

    }

    // 对方法1优化 利用取余
    public String reverseLeftWords3(String s, int n) {
        if (s == null || n <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            // 取余操作自动交换顺序
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();

    }

    public String reverseLeftWords2(String s, int n) {
        if (s == null || n <= 0) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }
}

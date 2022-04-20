package exercise.lcswordoffer.day05._50;

import java.util.LinkedHashSet;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 * @author xuzhigang
 * @date 2022/4/19 8:55 下午
 **/
public class Solution {
    // set
    public char firstUniqChar(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        LinkedHashSet<Character> set1 = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (set.add(c)) {
                set1.add(c);
            } else {
                set1.remove(c);
            }
        }
        return set1.stream().findFirst().orElse(' ');
    }

    public static void main(String[] args) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        System.out.println(set.add('a'));
        System.out.println(set.add('a'));
    }
}

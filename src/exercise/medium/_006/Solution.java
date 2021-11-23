package exercise.medium._006;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @author xuzhigang
 * @date 2021/11/23 7:59 上午
 **/
public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        // 将每一行使用StringBuilder维护，使用list维护n行
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        // 遍历字符串，按行添加，遇到z形节点，翻转行序
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            // numRows-1表示最后一行 0表示第一行，都是节点部分
            if (i == numRows - 1 || i == 0) {
                // 第一次正序加行数
                // 第二次逆序减行数
                // 反复循环
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        rows.forEach(res::append);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ab", 1));
    }
}

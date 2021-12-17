package exercise.easy._014;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 暴力解
     * 两两取公共前缀 取到空为止；
     */
    public static String longestCommonPrefix1(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        result = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            result = twoStrCommonPrefix(result, strs[i + 1]);
            // 提前退出
            if ("".equals(result)) {
                return result;
            }
        }
        return result;
    }

    private static String twoStrCommonPrefix(String a, String b) {
        int length = a.length() < b.length() ? a.length() : b.length();
        String result = "";
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (i == 0) {
                    return result;
                }
                return a.substring(0, i);
            }
            result = a.substring(0, length);

        }
        return result;
    }


    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(a));
        String x = "flow";
        String y = "flight";
        System.out.println(twoStrCommonPrefix(x, y));
    }
}

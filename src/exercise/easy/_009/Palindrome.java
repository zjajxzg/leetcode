package exercise.easy._009;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Palindrome {
    /**
     * 利用第7题的reverse方法解  reverse之后比较是否相同即可
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int i = 1;
        int xx = x;
        while (true) {
            x = x / 10;
            if (x == 0) {
                break;
            }
            i++;
        }
        int z = 0;
        int num;
        for (int j = 1; j <= i; j++) {
            num = xx % (int) (Math.pow(10, j)) / (int) Math.pow(10, j - 1);
            z += num * (int) (Math.pow(10, (i - j)));
        }
        System.out.println(z);
        return z == xx;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        // 除以10!=0
        int reverse = 0;
        int tem = x;
        while (x != 0) {
            reverse = reverse * 10 +  x % 10;
            x /= 10;
        }
        return reverse == tem;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome2(-121));
    }
}

package exercise.easy._007;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class Reverse {

    /**
     * 先计算出x的长度i   然后for循环i次，每次%10的j次方取余数 再/10的j-1次取出每一位的值  再乘以10的i-j次倒序相加
     * 注意点（int的范围是-2^31~2^31-1,不仅要考虑x不能超过这个范围    还要考虑反转后的值不能超过这个范围）
     * 基本就是数学的思路
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        // 废逻辑
        if ((long) x > Integer.MAX_VALUE || (long) x < Integer.MIN_VALUE) {
            return 0;
        }
        int i = 1;
        int xx = x;
        // 不需要
        while (true) {
            x = x / 10;
            if (x == 0) {
                break;
            }
            i++;
        }
        long z = 0;
        int num;
        for (int j = 1; j <= i; j++) {
            num = xx % (int) (Math.pow(10, j)) / (int) Math.pow(10, j - 1);
            z += (long) num * (int) (Math.pow(10, (i - j)));
        }
        if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) z;
    }

    public static int reverse2(int x) {
        // x / 10 != 0 遍历x每一位 用long接收溢出值
        long res = 0;
        while (x != 0) {
            // 取余 获取最后一位
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse1(x));
        System.out.println(reverse2(x));
    }
}

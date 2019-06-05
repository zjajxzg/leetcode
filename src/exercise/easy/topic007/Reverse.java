package exercise.easy.topic007;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
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
        if ((long) x > Integer.MAX_VALUE || (long) x < Integer.MIN_VALUE) {
            return 0;
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

    public static void main(String[] args) {
        System.out.println(reverse1(12));
    }
}

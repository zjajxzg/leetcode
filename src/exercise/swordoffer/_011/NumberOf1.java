package exercise.swordoffer._011;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    /**
     * 解题思路
     * 二进制数不等于0时必定是有1的，二进制数减一的结果与本身做与运算得到的结果是从右边起第一个1后面都变成了0
     * 比如1011   -1后=1010     1011 & 1010 = 1010   执行一次这样的操作  就会少一个1  直到为0
     * @param n
     * @return
     */
    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // 1011 十进制是 11
        // return 3
        System.out.println(numberOf1(11));
    }
}

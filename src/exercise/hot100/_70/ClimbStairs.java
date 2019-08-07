package exercise.hot100._70;

import java.util.ArrayList;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {
    /**
     * 递归 超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);

    }

    /**
     * 递归优化   记忆式搜索  （自顶向下）
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n];

        if (arr[n-1] == 0) {
            arr[n-1] = climbStairs1(n-1) + climbStairs1(n-2);
            return arr[n-1];
        }
        return arr[n-1];

    }

    /**
     * 动态规划 （自底向上）
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new ClimbStairs().climbStairs1(5));
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(endTime - startTime);
    }
}

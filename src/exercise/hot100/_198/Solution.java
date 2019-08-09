package exercise.hot100._198;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 递归超时
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[n - 1];
        }
        if (n == 2) {
            return Math.max(nums[n - 1], nums[n - 2]);
        }
        if (n == 3) {
            return Math.max(nums[n - 2], nums[n - 1] + nums[n - 3]);
        }
        return Math.max(rob(Arrays.copyOfRange(nums, 0, n - 2)) + nums[n - 1],
                rob(Arrays.copyOfRange(nums, 0, n - 3)) + nums[n - 2]);
    }

    /**
     * dp    dp[i] = max(dp[i-2]+nums[i], dp[i-1])
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[n - 1];
        }
        if (n == 2) {
            return Math.max(nums[n - 1], nums[n - 2]);
        }
        int[] temp = new int[n];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            temp[i] = Math.max(temp[i - 1], nums[i] + temp[i - 2]);
        }
        return temp[n - 1];
    }

    public static void main(String[] args) {

        int[] a = {2,7,9,3,1};
        System.out.println(rob1(a));
    }
}
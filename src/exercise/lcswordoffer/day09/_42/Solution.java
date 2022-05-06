package exercise.lcswordoffer.day09._42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author xuzhigang
 * @date 2022/5/3 10:21 上午
 **/
public class Solution {

    /**
     * f(n) = max(f(n-1)+nums[n], nums[n])
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int max2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max2 > 0) {
                max2 += nums[i];
            } else {
                max2 = nums[i];
            }
            max = Math.max(max, max2);
        }
        return max;
    }

    // f(n) = max(f(n-1)+nums[n], nums[n])
//    public int maxSubArray2(int[] nums) {
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            max = Math.max(max, max2);
//        }
//        return max;
//    }
}

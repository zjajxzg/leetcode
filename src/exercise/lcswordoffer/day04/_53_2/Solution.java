package exercise.lcswordoffer.day04._53_2;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 *
 * @author xuzhigang
 * @date 2022/4/15 8:29 上午
 **/
public class Solution {
    // 暴力
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    // 二分
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出  不用(left + right) / 2
            int mid = left + (right - left) / 2;
            // 相等 说明在后半部分 不相等说明在前半部分
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 当找到
        return left;
    }

    // 二分优化 提前退出
    public static int missingNumber3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出  不用(left + right) / 2
            int mid = left + (right - left) / 2;
            // 相等 说明在后半部分 不相等说明在前半部分
            if (nums[mid] == mid) {
                left = mid + 1;
                if (left <= right && nums[left] != left) {
                    return left;
                }
            } else {
                right = mid - 1;
                if (left <= right && nums[right] == right) {
                    return mid;
                }
            }
        }
        // 当找到
        return left;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber3(new int[]{0}));
    }
}

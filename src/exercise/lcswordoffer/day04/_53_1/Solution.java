package exercise.lcswordoffer.day04._53_1;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author xuzhigang
 * @date 2022/4/11 9:54 下午
 **/
public class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 条件 有序数组->二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        //
        int start = 0;
        int end = nums.length;
        int mid = -1;
        while (start < end) {
            // 有溢出风险 mid = start + (end - start) / 2
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
                continue;
            }
            if (nums[mid] < target) {
                start = mid;
                continue;
            }
            break;
        }
        if (mid == -1) {
            return 0;
        }
        int right = mid;
        int left = mid;
        for (int i = mid; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[mid]) {
                right = i;
                break;
            }
        }
        for (int i = mid; i > 0; i--) {
            if (nums[i - 1] != nums[mid]) {
                left = i;
                break;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(search2(arr, 8));
    }
}

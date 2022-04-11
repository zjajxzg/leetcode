package exercise.lcswordoffer.day03._03;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * @author xuzhigang
 * @date 2022/4/11 8:30 上午
 **/
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 题意
     * 所有数字都在0~n-1之间，原地交换
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            // 原地不断交换 当前索引的位置对了之后再走下一步
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 0, 0, 1};
        System.out.println(findRepeatNumber2(arr));

    }


}

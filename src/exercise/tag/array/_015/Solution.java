package exercise.tag.array._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author xuzhigang
 * @date 2020/7/26 5:17 下午
 **/
public class Solution {

    /**
     * 暴力   超时
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 遍历+双指针   指定一个数后  另外两个数的确定可以使用两数之和的方式来确定（双指针）
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 排序 O(nlogn) 为双指针做铺垫
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // i>0 三个数都>0  直接退出
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            // 双指针  两数之和=target
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    // 去重
                    if (left == i + 1 || (left > i + 1 && nums[left] != nums[left-1])) {
                        result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    }
                    left++;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSum2(nums));
    }
}

package exercise.easy._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 暴力解法O(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash o(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        // key: 数值 value: 数组index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            // 排除特殊情况
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }

//    /**
//     * 双指针   先排序  头尾两指针的和大于target（这里不适用 排序之后index变了）
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] twoSum2(int[] nums, int target) {
//        Arrays.sort(nums);
//        for (int i = 0, j = nums.length - 1; i < j; i++) {
//            while (nums[i] + nums[j] > target) {
//                j--;
//            }
//            if (nums[i] + nums[j] == target) {
//                return new int[]{i, j};
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(a.twoSum3(nums, target)));
    }
}

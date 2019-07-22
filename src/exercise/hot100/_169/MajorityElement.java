package exercise.hot100._169;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > length / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 由题意得，排序后中位数一定是众数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 3, 2, 2};
        System.out.println(new MajorityElement().majorityElement(arr));
        System.out.println(3 / 2);
    }
}

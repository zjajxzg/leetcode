package exercise.hard._004;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author xuzhigang
 * @date 2021/11/19 8:36 下午
 **/
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 两个源数组的长度不一样，那么假设其中短的数组用完了,即全部放入到新数组中去了,那么长数组中剩下的那一段
        // 就可以直接拿来放到新数组中去了
        int[] c = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] >= nums2[j]) {
                c[k++] = nums2[j++];
            } else {
                c[k++] = nums1[i++];
            }
        }

        while (j < nums2.length) {
            c[k++] = nums2[j++];
        }
        while (i < nums1.length) {
            c[k++] = nums1[i++];
        }

        // 有序数组取中位数
        int mid = c.length / 2;
        // 奇数
        if (c.length % 2 == 1) {
            return c[mid];
        }
        // 偶数
        return (c[mid] + c[mid - 1]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

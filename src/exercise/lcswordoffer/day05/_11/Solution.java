package exercise.lcswordoffer.day05._11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author xuzhigang
 * @date 2022/4/19 8:05 上午
 **/
public class Solution {
    // 暴力
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    // 二分 4,5,1,2,3
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[mid+1]) {
                return numbers[mid+1];
            }
            // 处于前半段
            if (numbers[mid] > numbers[0]) {
                left = mid + 1;
                continue;
            }
            // 处于后半段
            if (numbers[mid] < numbers[0]) {
                right = mid - 1;
                continue;
            }
            // 相等时 退化成线性查找
            while (left <= right) {
                if (numbers[left] > numbers[left+1]) {
                    return numbers[left+1];
                }
                left++;
            }
        }
        return numbers[0];
    }
}

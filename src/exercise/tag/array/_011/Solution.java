package exercise.tag.array._011;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhigang.xu
 */
public class Solution {
    /**
     * 双指针  分析面积的情况  可以发现从前后向中间移动指针 可以覆盖所有的面积情况 且指针较小值移动即可
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        // 边界 题目以及规则length >= 2了 有没有无所谓
        if (height == null || height.length == 1) {
            return 0;
        }
        // 记录最大值 利用双指针计算
        int maxArea = 0;
        int j = height.length - 1;
        int i = 0;
        while (i != j) {
            if (height[i] <= height[j]) {
                maxArea = Math.max(height[i] * (j - i), maxArea);
                i++;
            } else {
                maxArea = Math.max(height[j] * (j - i), maxArea);
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

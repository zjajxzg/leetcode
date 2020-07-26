package exercise.tag.array._066;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuzhigang
 * @date 2020/7/23 8:34 下午
 **/
public class Solution {

    /**
     * 记录进位 flag=1  当当前位<9时直接+1停止 =9时 当前位变为0，下一位继续   考虑全是9的特殊情况 返回一个长度+1的数组 第一位置为1即可
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int flag = 1;
        int i = digits.length - 1;
        while (flag == 1 && i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                flag = 0;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    flag = 0;
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                }
            }
            i--;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}

package exercise.tag.array._118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author xuzhigang
 * @date 2020/7/27 10:20 下午
 **/
public class Solution {

    /**
     * 基本算是暴力解 官方题解思路基本一致 说是动态规划 学完dp再看看吧
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i > 0) {
                for (int j = 1; j < i; j++) {
                    list.add(result.get(i-1).get(j - 1) + result.get(i-1).get(j));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }

    // todo 杨辉三角规律   本行元素等于上一行元素往后错一位再逐个相加：
    // 1 2 1 0
    // 0 1 2 1
    // 1 3 3 1
}

package exercise.tag.array._119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author xuzhigang
 * @date 2020/7/28 10:10 下午
 **/
public class Solution {
    /**
     * 通过杨辉三角第一题实现 空间复杂度过大
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return result.get(rowIndex);
    }

    /**
     * todo 优化方法1 只需要记录上一次的结果 感觉内存占用应该少了可是结果一样  回头再刷吧
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> temp;
        List<Integer> next = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            next.add(1);
            if (i > 0) {
                for (int j = 1; j < i; j++){
                    next.add(pre.get(j-1) + pre.get(j));
                }
                next.add(1);
            }
            temp = pre;
            pre = next;
            temp.clear();
            next = temp;

        }
        return pre;
    }
}

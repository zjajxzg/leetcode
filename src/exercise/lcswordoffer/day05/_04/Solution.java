package exercise.lcswordoffer.day05._04;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 *
 * @author xuzhigang
 * @date 2022/4/17 12:39 下午
 **/
public class Solution {
    /**
     * 暴力
     * 没有利用递增的条件
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 列
        for (int i = 0; i < matrix[0].length; i++) {
            // 行
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 翻转二维数组 可以发现变成一个类似于二插搜索树结构，matrix[0,n]为头节点，比他大的向右（下）移动，比他小的向左移动
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 代表列数
        int columnLength = matrix[0].length;
        // 代表行数
        int rowLength = matrix.length;
        // 行指针
        int n = 0;
        // 列指针
        int m = columnLength - 1;
        // 退出条件 超出数组范围
        while (n < rowLength && m >= 0) {
            if (matrix[n][m] > target) {
                m--;
                continue;
            }
            if (matrix[n][m] < target) {
                n++;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];

    }
}

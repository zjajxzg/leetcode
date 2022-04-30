package exercise.lcswordoffer.day07._26;

import common.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * @author xuzhigang
 * @date 2022/4/24 4:53 下午
 **/
public class Solution {

    /**
     * 递归 经典dfs（深度优先遍历）
     *
     * 首先从根节点开始判断 两棵树同时进行深度优先遍历，递归左
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // A为空树或者B为空树 都不是子结构
        if (A == null || B == null) {
            return false;
        }
        // 判断是否是子结构
        // 终止条件
        // 1. B == null，说明B匹配完了，A还没完，那一段是子结构
        // 2. A == null, A完了，B还没完，那必然不是子结构
        // 3. a.val != b.val 两边数不相等，那也不是子结构
        // 递归，左左匹配，右右匹配
        if (recur(A, B)) {
            return true;
        }
        if (isSubStructure(A.left, B)) {
            return true;
        }
        if (isSubStructure(A.right, B)) {
            return true;
        }
        return false;
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

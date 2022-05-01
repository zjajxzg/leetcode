package exercise.lcswordoffer.day07._28;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author xuzhigang
 * @date 2022/5/1 9:43 上午
 **/
public class Solution {

    /**
     * 递归
     * 1.
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        return left != null && right != null && left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);
    }

    /**
     * 借助两个队列实现
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        // 从左往右添加进队列 先进先出
        leftQueue.add(root);
        Queue<TreeNode> rightQueue = new LinkedList<>();
        // 从右往左添加进
        rightQueue.add(root);
        while (!leftQueue.isEmpty()) {
            // 拿出队列的node
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            // 都为null 继续判断
            if (left == null && right == null) {
                continue;
            }
            // 任意一个为null 直接return false
            if (left == null || right == null) {
                return false;
            }
            // 不相等说明不是镜像
            if (left.val != right.val) {
                return false;
            }

            leftQueue.add(left.left);

            leftQueue.add(left.right);

            rightQueue.add(right.right);

            rightQueue.add(right.left);

        }
        return true;
    }


}

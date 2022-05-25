package exercise.hot100._101;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * @author xuzhigang
 * @date 2022/5/24 8:07 上午
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

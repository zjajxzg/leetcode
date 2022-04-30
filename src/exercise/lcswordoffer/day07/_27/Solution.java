package exercise.lcswordoffer.day07._27;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * @author xuzhigang
 * @date 2022/4/30 5:57 下午
 **/
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 思路 层序遍历 bfs（广度优先遍历） 借助队列，每一层从右往左加入队列即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}

package exercise.lcswordoffer.day06._32_1;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * @author xuzhigang
 * @date 2022/4/20 8:50 上午
 **/
public class Solution {
    /**
     * BFS 广度优先遍历 借助队列实现
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列
        queue.add(root);
        List<Integer> resList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            resList.add(treeNode.val);
            // 从左到右放入队列
            if (Objects.nonNull(treeNode.left)) {
                queue.add(treeNode.left);
            }
            if (Objects.nonNull(treeNode.right)) {
                queue.add(treeNode.right);
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }


}

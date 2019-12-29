package exercise.swordoffer._019;

import exercise.swordoffer.structure.TreeNode;

import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author zhigang.xu
 * @date 2019/10/7 19:49
 */
public class Solution {
    /**
     * 递归  结合前序和中序的特点   前序第一个是根节点
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0) {
            return null;
        }

        int rootVal = pre[0];

        // 数组长度仅为1的时候就要处理
        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }

        // 获取中序遍历rootVal的位置 确定左子树和右字树的位置
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        // 递归
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));

        return root;
    }
}

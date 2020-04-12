package me.weey.leetcode.tree;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.tree
 * @description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @date 2020-04-12 14:13
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (null == root) {
            return 0;
        }
        leftHeight = maxDepth(root.left) + 1;
        rightHeight = maxDepth(root.right) + 1;

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}

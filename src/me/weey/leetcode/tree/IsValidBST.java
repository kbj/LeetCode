package me.weey.leetcode.tree;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.tree
 * @description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @date 2020-04-12 14:50
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        if (null != root) {
            return checkTree(root, min, max);
        }

        return true;
    }

    public static boolean checkTree(TreeNode root, long min, long max) {
        if (null == root) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = checkTree(root.left, min, root.val < max ? root.val : max);
        boolean right = checkTree(root.right, root.val > min ? root.val : min, max);
        return left && right;
    }
}

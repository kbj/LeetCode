package me.weey.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.tree
 * @description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @date 2020-06-26 23:02
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);

        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        //空树是对称的
        if (null == root) {
            return true;
        }

//        return checkRecur(root.left, root.right);
        return checkFor(root, root);
    }

    /**
     * 迭代
     */
    public static boolean checkFor(TreeNode left, TreeNode right) {
        //使用队列
        Queue<TreeNode> treeNodes = new LinkedList<>();
        //加入两个
        treeNodes.offer(left);
        treeNodes.offer(right);

        while (!treeNodes.isEmpty()) {
            TreeNode l = treeNodes.poll();
            TreeNode r = treeNodes.poll();

            if (null == l && null == r) {
                return true;
            }
            if (null == l || null == r || l.val != r.val) {
                return false;
            }

            treeNodes.offer(l.left);
            treeNodes.offer(r.right);
            treeNodes.offer(l.right);
            treeNodes.offer(r.left);
        }

        return true;
    }

    /**
     * 递归
     */
    public static boolean checkRecur(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        //比较左边的左边和右边的右边，左边的右边和右边的左边
        return checkRecur(left.left, right.right) && checkRecur(left.right, right.left);
    }
}

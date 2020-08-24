package me.weey.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weey
 * @ program: Leetcode
 * @ package me.weey.leetcode.tree
 * @ description:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @date 2020-06-26 23:44
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //创建总的list
        List<List<Integer>> treeLists = new ArrayList<>();
        if (root != null) {
            //当前是二叉树的第几层
            int currentIndex = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            treeLists.add(list);
            if (root.left != null || root.right != null) {
                getLevelInteger(root.left, root.right, currentIndex, treeLists);
            }
        }
        return treeLists;
    }

    public static void getLevelInteger(TreeNode left, TreeNode right, int currentIndex, List<List<Integer>> treeLists) {
        currentIndex++;
        if (null != left || null != right) {
            List<Integer> list;
            if (currentIndex + 1 > treeLists.size()) {
                list = new ArrayList<>();
            } else {
                list = treeLists.get(currentIndex);
            }

            if (null != left) {
                list.add(left.val);
            }
            if (null != right) {
                list.add(right.val);
            }

            if (currentIndex + 1 > treeLists.size()) {
                treeLists.add(list);
            }

            if (null != left) {
                getLevelInteger(left.left, left.right, currentIndex, treeLists);
            }

            if (null != right) {
                getLevelInteger(right.left, right.right, currentIndex, treeLists);
            }
        }
    }
}

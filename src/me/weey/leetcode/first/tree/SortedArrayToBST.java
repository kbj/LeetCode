package me.weey.leetcode.first.tree;

/**
 * @author Weey
 * @ program: Leetcode
 * @ package me.weey.leetcode.first.tree
 * @ description:
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @date 2020-08-24 23:05
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        return recursiveSort(nums, 0, nums.length - 1);
    }

    public static TreeNode recursiveSort(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = recursiveSort(nums, start, index - 1);
        treeNode.right = recursiveSort(nums, index + 1, end);

        return treeNode;
    }
}

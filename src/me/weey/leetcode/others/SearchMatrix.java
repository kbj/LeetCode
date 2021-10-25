package me.weey.leetcode.others;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.println(searchMatrix(arr, 20));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 从左下角开始
        int one = matrix.length - 1;
        int two = 0;

        while (one >= 0 && two <= matrix[one].length) {
            // 先判断当前行
            if (matrix[one][two] == target) {
                return true;
            }
            if (matrix[one][two] > target) {
                one--;
                two = 0;
                continue;
            }
            if (matrix[one][two] < target) {
                two++;
            }
            if (two > matrix[one].length - 1) {
                one--;
                two = 0;
            }
        }
        return false;
    }
}

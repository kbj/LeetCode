package me.weey.leetcode.second.array;

/**
 * 编写一个高效的算法来搜索m x n矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109<= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109<= target <= 109
 * @author pc
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int one = 0, two = 0;
        while (one < matrix.length && two > -1) {
            // 先往左搜索
            int num = matrix[one][two];
            if (num == target) {
                return true;
            } else if (matrix[one][two] < target && two + 1 < matrix[one].length) {
                two++;
            } else {
                // 左边已到顶
                two = 0;
                one++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {3, 3, 8, 13, 13, 18},
                {4, 5, 11,13, 18, 20},
                {9, 9, 14,15, 23, 23},
                {13,18,22,22,25,27},
                {18,22,23,28,30,33},
                {21,25,28,30,35,35},
                {24,25,33,36,37,40}
        };
        System.out.println(searchMatrix(nums, 21));
    }
}

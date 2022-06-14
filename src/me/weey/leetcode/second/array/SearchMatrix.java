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
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int one = 0, two = 0;
        while (one < matrix.length && two > -1) {
            // 先往右搜索
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

    public static boolean searchMatrix(int[][] matrix, int target) {
        int one = 0, two = 0;
        boolean[][] way = new boolean[matrix.length][matrix[one].length];

        while (one < matrix.length && one > -1 && two > -1 && two < matrix[one].length) {
            way[one][two] = true;
            // 往下搜索
            if (matrix[one][two] == target) {
                return true;
            } else if (matrix[one][two] < target) {
                one++;
                if (one >= matrix.length) {
                    one--;
                    two++;
                }
            } else if (matrix[one][two] > target) {
                one--;
                if (one > -1 && way[one][two]) {
                    two++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30},
                {-1, 3}
        };
        System.out.println(searchMatrix(nums, 3));
    }
}

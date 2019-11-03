package me.weey.leetcode.array;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode
 * @description:
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * @date 2019-08-08 21:33
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(test1);
        System.out.println(test1);
    }

    public static void rotate(int[][] matrix) {
        int temp = 0;
        //先对角交换
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < i; i1++) {
                temp = matrix[i][i1];
                matrix[i][i1] = matrix[i1][i];
                matrix[i1][i] = temp;
            }
        }

        //列交换
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length / 2; i1++) {
                temp = matrix[i][i1];
                matrix[i][i1] = matrix[i][matrix.length - 1 - i1];
                matrix[i][matrix.length - 1 - i1] = temp;
            }
        }

        System.out.println(matrix);
    }
}

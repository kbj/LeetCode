package me.weey.leetcode.sort;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.sort
 * @description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]

 * 提示：
 *
 *     -10^9 <= nums1[i], nums2[i] <= 10^9
 *     nums1.length == m + n
 *     nums2.length == n
 * @date 2020-10-14 11:34
 */
public class Merge {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1, 3, num2, 3);
        System.out.println(num1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int index_1 = 0;
        int index_2 = 0;
        int temp_index = 0;

        while (index_1 < m || index_2 < n) {
            if (index_1 < m && index_2 < n) {
                if (nums1[index_1] < nums2[index_2]) {
                    temp[temp_index] = nums1[index_1];
                    temp_index++;
                    index_1++;
                } else if (nums1[index_1] > nums2[index_2]) {
                    temp[temp_index] = nums2[index_2];
                    temp_index++;
                    index_2++;
                } else {
                    temp[temp_index] = nums1[index_1];
                    temp_index++;
                    index_1++;
                    temp[temp_index] = nums2[index_2];
                    temp_index++;
                    index_2++;
                }
            } else if (index_1 < m) {
                temp[temp_index] = nums1[index_1];
                temp_index++;
                index_1++;
            } else {
                temp[temp_index] = nums2[index_2];
                temp_index++;
                index_2++;
            }
        }

        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }
}

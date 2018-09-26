package me.weey.leetcode.one;

import java.util.Arrays;

/**
 * 两个排序数组的中位数
 *
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 * @author Weey
 * @date 2018/09/27
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        //合并数组
        int[] newArray = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, newArray, nums1.length, nums2.length);

        //排序
        Arrays.sort(newArray);
        int length = newArray.length;
        if (length % 2 == 0) {
            int i = newArray[length / 2 - 1] + newArray[length / 2];
            System.out.println(i / 2.0);
        } else {
            Double value = (double) newArray[length / 2];
            System.out.println(value);
        }
    }
}

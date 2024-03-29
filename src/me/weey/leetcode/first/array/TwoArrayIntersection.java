package me.weey.leetcode.first.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 *
 * 注意：
 *
 *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *    我们可以不考虑输出结果的顺序。
 * 跟进:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * Created by Weey on 2018/04/19.
 */
public class TwoArrayIntersection {
    public static void main(String[] args) {
        int[] a1 = {-1, 2, -3, 0};
        int[] a2 = {20, 3, 2, 2, 2, 0, 1};
        int[] intersect = intersect(a1, a2);
        System.out.println(intersect);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
        ArrayList<Integer> integers = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums1[i]) j++;
            else {
                integers.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[integers.size()];
        for (int k=0; k<result.length; k++) {
            result[k] = integers.get(k);
        }
        return result;
    }
}

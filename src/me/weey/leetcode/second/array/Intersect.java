package me.weey.leetcode.second.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2 小，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author pc
 */
public class Intersect {
    /**
     * 用hashmap存储比较
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (nums2.length > nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        for (int i : nums1) {
            Integer count = map.get(i);
            if (null == count) {
                count = 0;
            }
            map.put(i, ++count);
        }

        for (int i : nums2) {
            Integer number = map.get(i);
            if (null == number || number == 0) {
                continue;
            }
            map.put(i, --number);
            result.add(i);
        }

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);

        List<Integer> temp = new ArrayList<Integer>();
        int index1 = 0, index2 = 0, length1 = nums1.length, length2 = nums2.length;

        // 将排序好后的数组通过双指针方式比较
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                temp.add(nums1[index1]);
                index1++;
                index2++;
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    /**
     * 快排
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start, r = end, standard = nums[start], temp;
        while (l < r) {
            // 右边找到小于基准数的数
            while (l < r && nums[r] >= standard) {
                r--;
            }

            while (l < r && nums[l] <= standard) {
                l++;
            }

            // 交换
            if (l != r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        // 交换基准数
        if (start != l) {
            temp = standard;
            nums[start] = nums[l];
            nums[l] = temp;
        }

        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}

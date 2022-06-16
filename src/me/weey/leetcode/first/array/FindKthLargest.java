package me.weey.leetcode.first.array;

import java.util.Arrays;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 104
 * -104<= nums[i] <= 104
 *
 * @author pc
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        quickSort3(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }

    /**
     * 快排（从大到小）
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
       int standard = nums[start];
       int l = start, r = end;

        while (l < r) {
            // 先从右边开始查询找大于基准值的数
            while (l < r && nums[r] <= standard) {
                r--;
            }

            // 再从左边开始找小于基准值的数索引
            while (l < r && nums[l] >= standard) {
                l++;
            }

            // 交换lr
            if (l != r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        // 到这里l=r，交换基准值和l/r
        if (start != l) {
            nums[start] = nums[l];
            nums[l] = standard;
        }

        // 递归
        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    private static void quickSort3(int[] nums, int start, int end){
        if(start>=end) {
            return;
        }
        //分区
        int standard = nums[end];
        int l = start;
        int r = end;
        int m = start;
        while (m<=r){
            if(nums[m] > standard){
                swap(nums, m, l);
                l++;
                m++;
            }else if(nums[m] < standard){
                swap(nums, m, r);
                r--;
            }else {
                m++;
            }
        }
        quickSort3(nums,start,l-1);
        quickSort3(nums,r+1,end);

    }

    private static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }
}

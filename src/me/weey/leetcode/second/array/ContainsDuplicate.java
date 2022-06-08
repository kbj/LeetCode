package me.weey.leetcode.second.array;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 示例3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * @author pc
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 快排实现
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start, r = end, temp;
        int standard = nums[start];
        while (l < r) {

            while (l < r && nums[r] >= standard) {
                r--;
            }

            while (l < r && nums[l] <= standard) {
                l++;
            }

            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        // 交换基准值
        temp = nums[l];
        nums[l] = nums[start];
        nums[start] = temp;

        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
}

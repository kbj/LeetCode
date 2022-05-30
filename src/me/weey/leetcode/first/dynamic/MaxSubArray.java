package me.weey.leetcode.first.dynamic;

/**
 * @author Weey
 * @description:最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000

 * @date 2021-05-28 16:45
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(nums));
    }

    /**
     * 运用最简单的嵌套循环遍历出最大值
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int tempCount = 0;

        for (int i = 0; i < nums.length; i++) {
            tempCount = nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                tempCount +=  nums[j];
                if (tempCount > max) {
                    max = tempCount;
                }
            }
        }
        return max;
    }

    /**
     * 借助数组使用动态规划求解
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] tempArray = new int[nums.length];
        tempArray[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 因为要取最大值，如果前一位为负数那么就可以抛弃
            tempArray[i] = Math.max(tempArray[i - 1], 0) + nums[i];
            max = Math.max(max, tempArray[i]);
        }

        return max;
    }

    /**
     * 使用变量，原理同2
     */
    public static int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int temp = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 因为要取最大值，如果前一位为负数那么就可以抛弃
            temp = Math.max(temp, 0) + nums[i];
            max = Math.max(max, temp);
        }

        return max;
    }
}

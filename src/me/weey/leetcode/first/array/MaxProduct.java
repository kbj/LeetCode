package me.weey.leetcode.first.array;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个32-位 整数。
 * 子数组 是数组的连续子序列。
 *
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证是一个 32-位 整数
 *
 * @author pc
 */
public class MaxProduct {
    public static int maxProduct2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = i; j < nums.length; j++) {
                temp = temp * nums[j];
                max = Integer.max(temp, max);
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE, max1 = 1, min1 = 1;
        for (int num : nums) {
            // 如果遇到负数，最大乘积就会变成最小
            if (num < 0) {
                int t = min1;
                min1 = max1;
                max1 = t;
            }
            max1 = Integer.max(num, num * max1);
            min1 = Integer.min(num, num * min1);
            max = Integer.max(max, max1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}

package me.weey.leetcode.first.array;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 *
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 *
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 *
 * 进阶：你可以在 O(1)的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * @author pc
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        // 输出数组
        int[] output = new int[nums.length];
        output[0] = 1;

        // 计算i左边数字的乘积
        for (int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        // 计算i右边元素的乘积
        int right = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        // 第一位的数字即为right的值
        output[0] = right;

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}

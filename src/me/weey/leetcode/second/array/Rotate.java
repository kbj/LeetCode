package me.weey.leetcode.second.array;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 * @author pc
 */
public class Rotate {
    /**
     * 超时解法
     */
    public static void rotate_slow(int[] nums, int k) {
        if (k == 0 || nums.length < 2) {
            return;
        }
        int length = nums.length;
        // 前移动多次的处理
        if (k >= length) {
            k = k % length;
        }

        for (int j = k; j > 0; j--) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    /**
     * 最简单的解法，先反转数组，然后以k为分界线分别反转
     */
    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length < 2) {
            return;
        }
        int length = nums.length;
        // 前移动多次的处理
        if (k >= length) {
            k = k % length;
        }

        // 反转整个数组
        reverseArray(nums, 0, length - 1);

        // 反转数组前k位
        reverseArray(nums, 0, k - 1);

        // 反转k以后的位
        reverseArray(nums, k, length - 1);
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7};
        rotate(test, 3);
//        int[] test = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
//        rotate(test, 82);
//        25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
        System.out.println(Arrays.toString(test));
    }

    /**
     * 反转数组
     * @param nums  数组
     * @param start 开始
     * @param end   结束
     */
    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

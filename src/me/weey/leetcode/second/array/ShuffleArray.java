package me.weey.leetcode.second.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是等可能的。
 *
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 示例 1：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * 提示：
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 104 次 reset 和 shuffle
 * @author pc
 */
public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }
    static class Solution {

        private final int[] nums;
        private final int[] origin;
        private final Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.origin = new int[nums.length];
            System.arraycopy(this.nums, 0, this.origin, 0, nums.length);
            this.random = new Random();
        }

        public int[] reset() {
            return this.origin;
        }

        public int[] shuffle() {
            int length = this.nums.length, temp;
            for (int i = 0; i < length; i++) {
                // 获得要与i交换的索引
                int nextIndex = random.nextInt(length - 1);
                temp = this.nums[i];
                this.nums[i] = this.nums[nextIndex];
                this.nums[nextIndex] = temp;
            }
            return this.nums;
        }
    }
}

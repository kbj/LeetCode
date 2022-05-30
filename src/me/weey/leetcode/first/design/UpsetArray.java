package me.weey.leetcode.first.design;

import java.util.Random;

/**
 * @author Weey
 * @description:给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * @date 2021-06-07 16:02
 */
public class UpsetArray {
    class Solution {

        int nums[];
        private Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if (null == nums) {
                return null;
            }
            // 随机打乱数组
            int[] newNums = nums.clone();
            for(int i = 0; i < newNums.length; i++){
                //从i~len中 随机选一个位置j和i位置做交换 得到n！排列结果
                int j = random.nextInt(newNums.length - i) + i;
                int temp = newNums[i];
                newNums[i] = newNums[j];
                newNums[j] = temp;
            }
            return newNums;
        }
    }
}

package me.weey.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 *
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 *
 * 注意事项:
 *
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数。
 * Created by Weey on 2018/05/04.
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 7, 0, 22, 3, 4, 0, 0, 2, 0, 222222, 3, 0, 2, 3, 4, 5, 6, 8, 9, 0, 0, 0, 3, 3, 4, 5, 2, 1, 3};
        moveZeroes(nums);
        moveZeroBest(nums);
    }

    public static void moveZeroes(int[] nums) {
        long startTime = System.currentTimeMillis();
        for (int i=0; i<nums.length - 1; i++) {
            for (int j=i + 1; j< nums.length; j++) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println("moveZeroes time:" + (endTime - startTime));
    }

    public static void moveZeroBest(int[] nums) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                //不等于0的话就不断往前面赋值，后面就补0
                nums[count++] = nums[i];
            }
        }

        for (; count<nums.length; count++) {
            nums[count] = 0;
        }

        long endTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(nums));

        System.out.println("moveZeroBest time:" + (endTime - startTime));
    }
}

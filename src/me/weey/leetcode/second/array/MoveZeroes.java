package me.weey.leetcode.second.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231<= nums[i] <= 231- 1
 * @author pc
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        int zeroIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex++] = nums[i];
            }
        }

        while (zeroIndex < length) {
            nums[zeroIndex] = 0;
            zeroIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}

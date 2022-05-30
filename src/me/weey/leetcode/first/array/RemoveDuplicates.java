package me.weey.leetcode.first.array;

/**
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 * 示例：
 * 给定数组: nums = [1,1,2],
 * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 * 不需要理会新的数组长度后面的元素
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3};
        int i = removeDuplicates(ints);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}

package me.weey.leetcode.first.array;

/**
 * 将包含 n 个元素的数组向右旋转 k 步。
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * 注意:                                [1,2,3,4,5,6]  [4,5,6,1,2,3]
 * 尽可能找到更多的解决方案，这里最少有三种不同的方法解决这个问题。
 * [显示提示]
 * 提示:
 * 要求空间复杂度为 O(1)
 * Created by kbj on 2018/03/12.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int[] ints1 = {1,2,3,4,5,6};
        rotate(ints1, 3);
    }

    public static void rotate(int[] nums, int k) {
        /**
         * 3元素在数组中的2位置上，(2+3) % 7 = 5
         * 5元素在数组中的4位置上，(4+3) % 7 = 0
         * 6元素在数组中的5位置上，(5+3) % 7 = 1
         * 7元素在数组中的6位置上，(6+3) % 7 = 2
         */
        int[] a = new int[nums.length];
        for(int i=0; i<nums.length;  i++){
            a[(i + k)%nums.length] =nums[i];
        }
        for(int i=0 ;i<nums.length; i++){
            nums[i] =a[i];
        }
    }
}

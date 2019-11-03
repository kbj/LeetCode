package me.weey.leetcode.array;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(22));
    }


    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121   1221
     * 输出: true
     *
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            //负数肯定不是
            return false;
        } else if (x < 10) {
            //个位数的数肯定是
            return true;
        }

        //把数转为数组
        String numString = Integer.toString(x);

        int length = numString.length();

        for (int i = 0; i < length / 2; i++) {
            if (numString.charAt(i) != numString.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

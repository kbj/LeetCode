package me.weey.leetcode.first.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * @author Weey
 * @date 2021-09-13 21:31
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }
    public static boolean isPowerOfThree(int n) {
        // 　logx(y) =loge(y) / loge(x)
        return (Math.log(n) / Math.log(3) + Math.E) % 1 <= 2 * Math.E;
    }
}

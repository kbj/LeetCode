package me.weey.leetcode.math;

/**
 * 统计所有小于非负整数n的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 提示：
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(5000000));
    }

    public static int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        // 当n > 2
        // 构建一个数组存放每次运算后得到的结果数量，index = 数字 - 1  value = 0为非质数，1为质数
        int[] nums = new int[n - 1];
        nums[1] = 1;
        int count = 1;
        first:
        for (int i = 2; i < n; i++) {
            // 判断i是否已判断过是否为质数
            if (nums[i - 1] == 0) {
                // 只需要从2到根号i循环判断就行
                for (int i1 = 2; i1 * i1 <= i; i1++) {
                    if (i % i1 == 0) {
                        // 不是质数
                        nums[i - 1] = 2;
                        continue first;
                    }
                }
                // 是质数
                count++;
                nums[i - 1] = 1;
                // i 的倍数都不为质数（排除重复的）
                int time = 2;
                while (i * i < n && i * time < n) {
                    nums[i * time - 1] = 2;
                    time++;
                }
            }
        }
        return count;
    }
}

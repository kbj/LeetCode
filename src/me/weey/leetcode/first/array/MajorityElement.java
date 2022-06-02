package me.weey.leetcode.first.array;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *  @author pc
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    /**
     * 常规思想解法
     */
    public static int majorityElement2(int[] nums) {
        int target = nums.length / 2;
        HashMap<Integer, Integer> used = new HashMap<>();
        for (int num : nums) {
            Integer count = used.get(num);
            if (count == null) {
                count = 0;
            }
            count++;
            if (count > target) {
                return num;
            }
            used.put(num, count);
        }
        return 0;
    }

    /**
     * 使用摩尔投票算法求解
     */
    public static int majorityElement(int[] nums) {
        // 用计数器的方式，如果相同数+1，不同数-1，构造不同数之间互相抵消
        // 如果计数器为0时就为次数多出来的那个数
        int count = 0;
        int maxNum = 0;
        for (int num : nums) {
            if (count == 0) {
                maxNum = num;
            }
            count += maxNum == num ? 1 : -1;
        }
        return maxNum;
    }
}

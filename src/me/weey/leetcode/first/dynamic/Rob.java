package me.weey.leetcode.first.dynamic;

/**
 * @author Weey
 * @description:打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @date 2021-05-28 17:34
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 定义一个二维数组int[x][2], [0]表示不偷能得到的金额，[1]表示偷能得到的金额
        int[][] count = new int[nums.length][2];
        count[0][0] = 0;
        count[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 不偷，上一家偷或者不偷都行，判断哪个大
            count[i][0] = Math.max(count[i-1][0], count[i-1][1]);
            // 偷，上一家一定不能偷，再加上这家的金额
            count[i][1] = count[i-1][0] + nums[i];
        }
        return Math.max(count[nums.length - 1][0], count[nums.length - 1][1]);
    }

    public static int rob2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 定义两个变量, not表示不偷能得到的金额，has表示偷能得到的金额
        int not = 0;
        int has = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempNot = not;
            // 不偷，上一家偷或者不偷都行，判断哪个大
            not = Math.max(tempNot, has);
            // 偷，上一家一定不能偷，再加上这家的金额
            has = tempNot + nums[i];
        }
        return Math.max(not, has);
    }
}

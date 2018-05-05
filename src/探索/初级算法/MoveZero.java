package 探索.初级算法;

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
        int[] nums = {0, 1, 0, 3, 12};
    }

    public static void moveZeroes(int[] nums) {
        //定义初始位置
        int lastNotZeroIndex = nums.length - 1;
        int temp, start;
        while (nums[lastNotZeroIndex] == 0) {
            lastNotZeroIndex--;
            if (nums[lastNotZeroIndex] != 0) {
                break;
            }
        }


    }
}

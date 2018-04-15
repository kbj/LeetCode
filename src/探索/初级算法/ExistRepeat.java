package 探索.初级算法;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 * Created by WeiKai on 2018/03/14.
 */
public class ExistRepeat {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 1, 4};
        System.out.println(containsDuplicate(ints));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }
        if (set.size() == nums.length) return false;
        return true;
    }
}

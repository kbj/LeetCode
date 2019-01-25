package me.weey.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素
 * 一个线性时间复杂度。 不用额外空间
 * Created by Weey on 2018/04/15.
 */
public class FindExistOne {
    public static void main(String[] args) {
        int[] ints = {10,186,-49,176,118,167,-61,189,6,-24,7,-93,71,112,187,45,-36,38,82,108,-46,112,51,165,-37,159,1,-53,7,38,90,181,-23,91,-42,172,-95,130,84,149,-47,68,126,-67,175,22,121,131,84,114,60,64,182,-75,-17,-71,69,-92,103,-91,-91,86,126,166,33,-36,-80,-37,118,-80,-18,127,36,-71,-82,-82,144,12,57,149,71,91,-83,-100,-30,45,186,16,-51,-72,-83,107,140,-97,-93,1,12,189,-61,-50,180,98,96,-29,193,167,57,-45,16,6,-76,4,109,-23,22,144,190,-97,193,-51,-99,-79,-47,142,107,175,109,121,190,90,34,32,63,-24,41,-53,41,89,130,-18,-99,103,86,127,-30,102,32,-49,181,-60,114,60,-29,182,-75,168,96,51,33,142,108,69,10,-57,166,48,82,161,-17,-50,102,63,-45,140,180,176,-95,36,-46,168,187,161,-72,-100,-42,165,-76,-67,89,159,64,34,98,4,-60,172,-79,68,48,131,-57};
        System.out.println(myAnswer(ints));
        System.out.println(bestAnswer(ints));
        int i = 1;
        int j = 2;
        System.out.println(i ^ j);
    }

    private static int myAnswer(int[] nums) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i:nums) {
            Integer integer = integerIntegerHashMap.get(i);
            if (integer == null) {
                integerIntegerHashMap.put(i, 1);
            } else {
                integerIntegerHashMap.remove(i);
            }
        }
        for (Integer value:integerIntegerHashMap.keySet()) {
            return value;
        }
        return -1;
    }

    private static int bestAnswer(int[] nums) {
        //还有个方法是排序
        int temp = nums[0];
        for(int i = 1; i< nums.length; i++){
            temp = temp ^ nums[i];
        }
        return temp;
    }
}

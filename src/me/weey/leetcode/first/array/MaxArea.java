package me.weey.leetcode.first.array;

public class MaxArea {
    public static void main(String[] args) {
        int[] s = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(s));
    }

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;
        int maxNum = 0;

        while (i != j) {
            if (height[i] < height[j]) {
                maxNum = Math.max((j - i) * height[i], maxNum);
                i++;
            } else {
                maxNum = Math.max((j - i) * height[j], maxNum);
                j--;
            }
        }

        return maxNum;
    }
}

package me.weey.leetcode

/**
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }


    public static String intToRoman(int num) {
        String[] romanString = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder r = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            while (num >= value[i]) {
                num -= value[i];
                r.append(romanString[i]);
            }
        }

        return r.toString();
    }
}

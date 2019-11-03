package me.weey.leetcode.array;

import java.util.HashMap;

/**
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>(16) {{
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }};

        int result = 0;

        while (s.length() > 0) {
            if (s.length() > 1) {
                //s的长度大于1
                String temp = s.substring(0, 2);
                if (null != hashMap.get(temp)) {
                    //说明两位数的罗马字符
                    result += hashMap.get(temp);

                    //将s的前两位去除
                    s = s.substring(2);
                } else {
                    //说明是一位数的罗马字符
                    result += hashMap.get(s.substring(0, 1));

                    //去除前一位
                    s = s.substring(1);
                }
            } else {
                //s的长度等于1
                result += hashMap.get(s);

                //去除前一位
                s = s.substring(1);
            }
        }

        return result;
    }
}

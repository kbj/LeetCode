package me.weey.leetcode.first.string;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.string
 * @description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @date 2019-11-20 22:41
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder builder = new StringBuilder();
        int index = 0;
        first:
        while (true) {
            char[] indexChar = strs[0].toCharArray();
            if (index >= indexChar.length) {
                break;
            }
            char tempChar = indexChar[index];

            for (int i = 1; i < strs.length; i++) {
                char[] charArray = strs[i].toCharArray();
                if (index >= charArray.length) {
                    break first;
                } else if (tempChar != charArray[index]) {
                    break first;
                }
            }

            builder.append(tempChar);
            index++;
        }

        return builder.toString();
    }
}

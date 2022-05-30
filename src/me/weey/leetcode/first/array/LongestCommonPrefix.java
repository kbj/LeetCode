package me.weey.leetcode.first.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"a"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";

        if (null == strs || strs.length == 0) {
            return result;
        }

        //数组中的最小长度
        String first = strs[0];
        if (null == first || "".equals(first)) {
            return result;
        }

        boolean isTrue = true;

        while (isTrue) {
            result += first.substring(0, 1);

            if (first.length() > 1) {
                first = first.substring(1);
            }

            //循环判断是否存在
            for (String s : strs) {
                if (!s.startsWith(result)) {
                    isTrue = false;
                    result = result.substring(0, result.length() - 1);
                    break;
                }
            }
        }

        return result;
    }
}

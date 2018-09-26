package me.weey.leetcode.one;

import java.util.HashMap;

/**
 * **无重复字符的最长子串**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 * @author Weey
 * @date 2018/09/26
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "aab";

        //if (s.equals(""))  return 0;
        int start = 0;
        int end;
        int max = 0;
        char[] sources = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>(sources.length);
        for (int i=0; i<sources.length; i++) {
            /*判断是否在map中*/
            Integer index = hashMap.get(sources[i]);
            if (null == index || index < start) {
                /*不在map中*/
                hashMap.put(sources[i], i);
                end = i;
            } else {
                /*已经在map中存在了*/
                start = index + 1;
                end = i;
                hashMap.put(sources[i], i);
            }

            max = end - start > max ? (end - start) : max;
        }
        System.out.println(max + 1);
    }
}

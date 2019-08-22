package me.weey.leetcode;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @date 2019-08-22 12:48
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "aa"));
    }

    public static boolean isAnagram(String s, String t) {
        //字母异位词定义应该是包含相同的字母，但是顺序不同
        // "silent”和“listen”是字母易位词，而“apple”和“aplee”不是易位词
        if ("".equals(s) && "".equals(t)) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
        }

        int[] count2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 97]++;
        }

        for (int i=0; i < count.length; i++) {
            if (count[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}

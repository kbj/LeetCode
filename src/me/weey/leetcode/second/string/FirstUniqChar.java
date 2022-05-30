package me.weey.leetcode.second.string;

/**
 * 给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 提示:
 * 1 <= s.length <= 105
 * s只包含小写字母
 * @author pc
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aaabbcde"));
    }

    /**
     * 通过两层循环判断，其中记录之前判断过重复的数减少循环次数
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了98.60%的用户
     */
    public static int firstUniqChar(String s) {
        char[] words = s.toCharArray();
        if (words.length == 1) {
            return 0;
        }

        // 标记
        boolean[] used = new boolean[26];
        for (int i = 0; i < words.length - 1; i++) {
            char current = words[i];
            if (used[current - 'a']) {
                continue;
            }

            int tempIndex = -1;
            for (int j = i + 1; j < words.length; j++) {
                if (current == words[j]) {
                    used[current - 'a'] = true;
                    tempIndex = j;
                    break;
                }
            }

            if (tempIndex == -1) {
                return i;
            }
        }

        // 检查最后一位
        if (!used[words[words.length - 1] - 'a']) {
            return words.length - 1;
        }
        return -1;
    }

    /**
     * 通过从头开始和从尾开始遍历得到对应字符的索引判断是否一致
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了98.60%的用户
     */
    public static int firstUniqChar2(String s) {
        char[] words = s.toCharArray();
        boolean[] used = new boolean[26];

        for (int i = 0; i < words.length; i++) {
            if (used[words[i] - 'a']) {
                continue;
            }

            int lastIndex = s.lastIndexOf(words[i]);
            if (i == lastIndex) {
                return i;
            }
            used[words[i] - 'a'] = true;
        }
        return -1;
    }
}

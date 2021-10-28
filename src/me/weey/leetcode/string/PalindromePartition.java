package me.weey.leetcode.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println(partition("cdd"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return lists;
        }

        char[] words = s.toCharArray();
        ArrayDeque<String> path = new ArrayDeque<>();
        dfs(words, 0, len, path, lists);
        return lists;
    }

    /**
     * 深度优先的回溯算法
     */
    public static void dfs(char[] words, int index, int len, ArrayDeque<String> path, List<List<String>> lists) {
        if (index == len) {
            // 走到头了以后开始回头
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 判断是否是回文
            if (!isPalindrome(words, index, i)) {
                continue;
            }
            // 压栈记录走的步骤
            path.addLast(new String(words, index, i - index + 1));

            dfs(words, i + 1, len, path, lists);

            // 出栈
            path.removeLast();
        }
    }

    public static boolean isPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

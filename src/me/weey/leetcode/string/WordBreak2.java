package me.weey.leetcode.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        // 存放最终结果的List
        List<String> lists = new ArrayList<>();
        ArrayDeque<String> path = new ArrayDeque<>();

        dfs(s.toCharArray(), 0, s.length(), path, lists, wordDict);

        return lists;
    }

    /**
     * 深度优先的回溯算法
     */
    public static void dfs(char[] words, int index, int len, ArrayDeque<String> path, List<String> lists, List<String> wordDict) {
        if (index == len) {
            // 走到头了以后开始回头
            StringBuilder temp = new StringBuilder();
            for (String s : path) {
                temp.append(" ");
                temp.append(s);
            }
            lists.add(temp.substring(1));
            return;
        }

        for (int i = index; i < len; i++) {
            // 压栈记录走的步骤
            String s = new String(words, index, i - index + 1);
            if (!wordDict.contains(s)) {
                continue;
            }
            path.addLast(s);

            dfs(words, i + 1, len, path, lists, wordDict);

            // 出栈
            path.removeLast();
        }
    }
}

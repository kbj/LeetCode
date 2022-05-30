package me.weey.leetcode.first.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 * 说明：拆分时可以重复使用字典中的单词。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *    注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        // 将wordDict转为set，方便判断重复
        HashSet<String> wordDicts = new HashSet<>(wordDict);
        // 定义一个数组判断s[0] - s[i]是否与wordDict存在重复
        boolean[] records = new boolean[length + 1];
        records[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (records[j] && wordDicts.contains(word)) {
                    records[i] = true;
                    break;
                }
            }
        }
        return records[length];
    }
}

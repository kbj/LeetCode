package me.weey.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，返回所有二维网格上的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * @author kbj
 */
public class FindWords {
    public static void main(String[] args) {
        String[] words = {"abcb"};
        char[][] board = {{'a', 'b'}, {'c', 'd'}};

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        // words构建前缀树，方便更快判断数组是否存在
        Trie trie = buildTrie(words);

        // 同一个单元格内的字母在一个单词中不允许被重复使用，记录是否被使用过
        int[][] used = new int[board.length][board[0].length];

        // 记录上次走的路，方便回溯
        StringBuilder path = new StringBuilder();

        // 存储最终结果，要去重
        HashSet<String> result = new HashSet<>();

        // 遍历二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie, used, path, result);
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 深度优先遍历
     * @param board     原始二维数组
     * @param i         一层数组遍历的索引
     * @param j         二层数组遍历的索引
     * @param trie      待判断单词的前缀树
     * @param used      记录使用过的数组
     * @param path      存储走过的路径
     * @param result    最终结果
     */
    private static void dfs(char[][] board, int i, int j, Trie trie, int[][] used, StringBuilder path, HashSet<String> result) {
        // 边界处理
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || trie.children[board[i][j] - 'a'] == null || used[i][j] == 1) {
            return;
        }

        // 记录路径
        path.append(board[i][j]);

        // 标记已使用
        used[i][j] = 1;

        // 如果当前的节点在前缀树中标记结束，那么应该就是最终结果
        if (trie.children[board[i][j] - 'a'].isEnd) {
            result.add(path.toString());
        }

        // 递归朝上下左右扩散
        dfs(board, i - 1, j, trie.children[board[i][j] - 'a'], used, path, result);
        dfs(board, i + 1, j, trie.children[board[i][j] - 'a'], used, path, result);
        dfs(board, i, j - 1, trie.children[board[i][j] - 'a'], used, path, result);
        dfs(board, i, j + 1, trie.children[board[i][j] - 'a'], used, path, result);

        // 还原标记和路径
        used[i][j] = 0;
        path.deleteCharAt(path.length() - 1);
    }

    /**
     * 构建前缀树
     * @param words 要构建前缀树的方法
     * @return  前缀树
     */
    public static Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Trie current = root;
            for (char a : chars) {
                if (null == current.children[a - 'a']) {
                    current.children[a - 'a'] = new Trie();
                }
                current = current.children[a - 'a'];
            }
            current.isEnd = true;
        }
        return root;
    }
}

class Trie {
    /**
     * 是否是单词结束
     */
    boolean isEnd;

    /**
     * 子节点
     */
    Trie[] children;

    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }
}

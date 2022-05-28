package me.weey.leetcode.tree;

/**
 * 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *     Trie() 初始化前缀树对象。
 *     void insert(String word) 向前缀树中插入字符串 word 。
 *     boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 *     boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 提示：
 *     1 <= word.length, prefix.length <= 2000
 *     word 和 prefix 仅由小写英文字母组成
 *     insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * @author kbj
 * @date 2022-02-06 22:04
 */
class Trie {
    /**
     * 构建一个前缀树节点
     */
    static class TrieNode {
        // 是否是单词的结束
        boolean isWordEnd;
        // 子节点
        TrieNode[] children;

        public TrieNode() {
            isWordEnd = false;
            children = new TrieNode[26];
        }
    }

    private final TrieNode node;

    public Trie() {
        node = new TrieNode();
    }

    public void insert(String word) {
        // 将word转为字符数组
        char[] words = word.toCharArray();
        // 递归方式
        // insertRecursive(this.node, 0, words);

        // 非递归方式
        TrieNode currentNode = this.node;
        for (char c : words) {
            int wordIndex = c - 'a';
            TrieNode child = currentNode.children[wordIndex];
            if (null == child) {
                child = new TrieNode();
                currentNode.children[wordIndex] = child;
            }
            currentNode = child;
        }
        currentNode.isWordEnd = true;
    }

    /**
     * 插入的递归方法
     */
    private void insertRecursive(TrieNode currentNode, int index, char[] words) {
        if (index == words.length) {
            // 表示已经到顶了
            currentNode.isWordEnd = true;
            return;
        }
        int wordIndex = words[index] - 'a';
        TrieNode child = currentNode.children[wordIndex];
        if (null == child) {
            child = new TrieNode();
            currentNode.children[wordIndex] = child;
        }
        insertRecursive(child, ++index, words);
    }

    public boolean search(String word) {
        char[] words = word.toCharArray();
        TrieNode trieNode = this.node;

        int index = 0;
        int length = words.length;

        while (index < length) {
            int wordIndex = words[index] - 'a';
            TrieNode child = trieNode.children[wordIndex];
            if (null == child) {
                return false;
            }
            index++;
            trieNode = child;
        }

        return trieNode.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TrieNode trieNode = this.node;

        int index = 0;
        int length = words.length;

        while (index < length) {
            int wordIndex = words[index] - 'a';
            TrieNode child = trieNode.children[wordIndex];
            if (child == null) {
                return false;
            }
            index++;
            trieNode = child;
        }
        return true;
    }
}

public class TrieTree {
    public static void main(String[] args) {
        //["insert","search","search","startsWith","startsWith","insert","search","startsWith","insert","search","startsWith"]
        //[["ab"],  ["abc"],  ["ab"],   ["abc"],      ["ab"],    ["ab"], ["abc"],   ["abc"],   ["abc"],  ["abc"],   ["abc"]]
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("ab"));
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("abc"));
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("abc"));
    }
}

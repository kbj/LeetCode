package me.weey.leetcode.string;

/**
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

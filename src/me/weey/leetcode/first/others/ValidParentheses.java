package me.weey.leetcode.first.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> v = new Stack<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == ')' || c == ']' || c == '}') {
                if (v.empty()) {
                    return false;
                }
                // 栈推出
                Character pop = v.pop();
                switch (c) {
                    case ')':
                        if (pop != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (pop != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (pop != '{') {
                            return false;
                        }
                        break;
                }
            } else {
                v.push(c);
            }
        }
        return v.empty();
    }
}

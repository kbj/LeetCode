package me.weey.leetcode;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode
 * @description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * @date 2019-08-23 12:37
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        } else if (s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isRight(leftChar)) {
                left++;
                continue;
            } else if (!isRight(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 检查是否为大小写英文字母或者数字
     *
     * @param c
     * @return
     */
    private static boolean isRight(char c) {
        if (c >= 97 && c <= 122) {
            return true;
        } else if (c >= 65 && c <= 90) {
            return true;
        } else {
            return c >= 48 && c <= 57;
        }
    }
}

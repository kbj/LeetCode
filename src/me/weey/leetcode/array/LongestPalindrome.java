package me.weey.leetcode.array;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 如果一个字符串正着读和反着读是一样的，那它就是回文串
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author Weey
 * @date 2018/09/29
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(s.length());
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String cuan = "";

        for (int i=0; i<s.length() - 1; i++) {
            StringBuilder builder = new StringBuilder(String.valueOf(s.charAt(i)));
            if (cuan.length() < builder.toString().length()) {
                cuan = builder.toString();
            }
            for (int j=i+1; j<s.length(); j++) {
                builder.append(String.valueOf(s.charAt(j)));
                Boolean isTrue = check(builder.toString());
                if (isTrue) {
                    if (builder.toString().length() > cuan.length()) {
                        cuan = builder.toString();
                    }
                }
            }
        }
        return cuan;
    }

    private static Boolean check(String toString) {
        char[] charArray = toString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = charArray.length - 1; i>=0; i--) {
            stringBuilder.append(String.valueOf(charArray[i]));
        }
        return stringBuilder.toString().equals(toString);
    }
}

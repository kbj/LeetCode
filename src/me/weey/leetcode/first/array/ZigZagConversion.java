package me.weey.leetcode.first.array;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "A";
        String convert = convert(s, 2);
        System.out.println(convert);
    }


    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     */
    public static String convert(String s, int numRows) {
        if (s.isEmpty()) {
            return s;
        }
        //算出当前行数下构成一个N所需要的字母数
        int wordNum = numRows * 2 - 2;
        if (wordNum <= 0) {
            wordNum = 1;
        }
        //存放最终结果的数组
        String[] wordArray = new String[numRows];

        int step = 0;
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            if (i % wordNum == 0) {
                count = 0;
                step = 0;
            } else {
                count++;
            }

            if (count != 0) {
                if (count >= numRows) {
                    step --;
                } else {
                    step ++;
                }
            }

            if (null == wordArray[step]) {
                wordArray[step] = s.charAt(i) + "";
            } else {
                wordArray[step] = wordArray[step] + s.charAt(i);
            }
        }

        StringBuilder a = new StringBuilder();
        for (String w : wordArray) {
            if (null == w || w.isEmpty()) {
                continue;
            }
            a.append(w);
        }
        return a.toString();
    }
}

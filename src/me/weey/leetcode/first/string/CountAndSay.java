package me.weey.leetcode.first.string;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.string
 * @description: 循环解法
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * @date 2019-11-06 12:46
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }

    public static String getNumber(String n) {
        StringBuilder result = new StringBuilder();
        Character temp = null;
        int count = 0;

        for (char c : n.toCharArray()) {
            if (null == temp || c == temp) {
                //和之前相等或者第一次初始化时候计算加一
                count++;
                temp = c;
            } else {
                //出现不等于的字符
                result.append(count).append(temp);
                temp = c;
                count = 1;
            }
        }
        //把最后统计加回结果
        result.append(count).append(temp);
        return result.toString();
    }

    private static String countAndSay(int n) {
        int index = 0;
        String result = "1";
        while (index < n - 1) {
            result = getNumber(result);
            index++;
        }

        return result;
    }
}

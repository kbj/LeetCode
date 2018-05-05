package 探索.初级算法;

import java.math.BigDecimal;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * Created by Weey on 2018/05/04.
 */
public class AddOne {
    public static void main(String[] args) {
        int[] ints = {8, 9, 4, 5, 0, 0, 7, 9};
        int[] result = plusOne(ints);
    }
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i:digits) {
            stringBuilder.append(i);
        }
        BigDecimal bigDecimal = new BigDecimal(stringBuilder.toString());
        BigDecimal one = new BigDecimal("1");
        String resultNum = bigDecimal.add(one).toString();

        int[] result = new int[resultNum.length()];
        for (int i=0; i<result.length; i++) {
            Character c = resultNum.charAt(i);
            result[i] = Integer.parseInt(c.toString());
        }
        return result;
    }
}

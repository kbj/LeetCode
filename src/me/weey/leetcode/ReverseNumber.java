package me.weey.leetcode;


public class ReverseNumber {
    public static void main(String[] args) {
        int reverse = reverse(-2147483648);
        System.out.println(reverse);
    }


    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 1234  4321
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
     */
    public static int reverse(int x) {
        //个位数判断直接返回
        if (x > -10 && x < 10) {
            return x;
        }

        //转成字符串
        String num = x + "";
        boolean negative = num.startsWith("-");
        if (negative) {
            num = num.substring(1);
        }
        char[] numChar = num.toCharArray();

        char temp;

        for (int i=0; i<numChar.length / 2; i++) {
            temp = numChar[i];
            numChar[i] = numChar[numChar.length - 1 - i];
            numChar[numChar.length - 1 - i] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (negative) {
            stringBuilder.append("-");
        }

        for (char c : numChar) {
            stringBuilder.append(c);
        }

        Integer result;
        try {
            result = Integer.valueOf(stringBuilder.toString());
        } catch (Exception e){
            return 0;
        }
        return result;
    }
}

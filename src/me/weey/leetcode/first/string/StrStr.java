package me.weey.leetcode.first.string;


/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.string
 * @description: 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @date 2019-11-05 07:25
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle)) {
            return 0;
        }

        if (null == haystack || "".equals(haystack)) {
            return -1;
        }

        char[] hayCharArray = haystack.toCharArray();
        int hayLength = hayCharArray.length;
        char[] needleCharArray = needle.toCharArray();
        int needleLength = needleCharArray.length;

        //构造一个map存储部分匹配表
//        int[] pmtArray = new int[needleLength];
//        for (int i = 0; i < needleLength; i++) {
//            pmtArray[i] = getPMT(needleCharArray, i);
//        }
        int[] pmtArray = getPmtFast(needleCharArray, needleLength);

        int i = 0, j = 0;
        boolean match = false;
        while (i < hayLength && j < needleLength) {
            //如果字符串匹配，i与j同时加1
            if (hayCharArray[i] == needleCharArray[j]) {
                i++;
                j++;
                match = true;
            } else if (!match) {
                //字符不相等且两个字符串还没有匹配成功过
                i++;
            } else {
                //字符不相同但是两个字符串已经有成功匹配过了
                j = j - (j - pmtArray[j-1]);
                if (j == 0) {
                    match = false;
                }
            }
        }

        if (j == needleLength) {
            return i - j;
        }
        return -1;
    }

    /**
     * 计算当前字符串的部分匹配值
     *
     * @param total 待匹配的字符数组
     * @return 部分匹配值
     */
    private static int[] getPmtFast(char[] total, int totalLength) {
        int[] maxMatchLengths = new int[totalLength];
        int maxLength = 0;
        for (int i = 1; i < totalLength; i++) {
            while (maxLength > 0 && total[maxLength] != total[i]) {
                maxLength = maxMatchLengths[maxLength - 1];
            }
            if (total[i] == total[maxLength]) {
                maxLength++;
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }

    /**
     * 计算当前索引值的部分匹配值（效率较差）
     *
     * @param total 待匹配的字符数组
     * @param index 当前的字符索引
     * @return 部分匹配值
     */
    private static int getPMT(char[] total, int index) {
        //只有一位数的前缀后缀都为0
        if (index == 0) {
            return 0;
        }

        //存放前缀和后缀
        String[][] array = new String[2][index];

        //计算前缀
        StringBuilder pre = new StringBuilder();
        for (int i = 0; i < index; i++) {
            pre.append(total[i]);
            array[0][i] = pre.toString();
        }

        //计算后缀
        StringBuilder after = new StringBuilder();
        for (int i = index; i > 0; i--) {
            after.insert(0, total[i]);
            array[1][i-1] = after.toString();
        }

        int count = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i].equals(array[1][index-1-i])) {
                count = Math.max(count, array[0][i].length());
            }
        }

        return count;
    }


    private void test() {
        char[] charArray = "ABCDABD".toCharArray();


    }
}

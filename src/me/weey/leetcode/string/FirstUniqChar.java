package me.weey.leetcode.string;

import java.util.HashMap;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode
 * @description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * @date 2019-08-08 22:12
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if (null == s || s.isEmpty()) {
            return -1;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Integer index = hashMap.get(charArray[i]);
            if (null == index) {
                hashMap.put(charArray[i], i);
            } else if (-1 != index){
                hashMap.put(charArray[i], -1);
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (Integer value : hashMap.values()) {
            if (value != -1) {
                if (value < minIndex) {
                    minIndex = value;
                }
            }
        }

        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minIndex;
        }
    }
}

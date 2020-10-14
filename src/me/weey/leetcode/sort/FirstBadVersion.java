package me.weey.leetcode.sort;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.sort
 * @description: TODO
 * @date 2020-10-14 16:17
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int medium = start + ((end - start) / 2);
            if (!isBadVersion(medium)) {
                start = medium;
                if (end - start <= 1) {
                    return end;
                }
            } else {
                if (medium - 1 >= start && !isBadVersion(medium - 1)) {
                    return medium;
                }
                end = medium;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int version) {
        return version > 1702766718;
    }
}

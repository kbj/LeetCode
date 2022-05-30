package me.weey.leetcode.first.bit;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> total = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 < i; i1++) {
                if (i1 == 0 || i1 == i-1) {
                    list.add(1);
                } else {
                    List<Integer> temp = total.get(i - 2);
                    list.add(temp.get(i1 - 1) + temp.get(i1));
                }
            }
            total.add(list);
        }
        return total;
    }
}

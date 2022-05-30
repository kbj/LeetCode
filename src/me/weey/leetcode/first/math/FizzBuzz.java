package me.weey.leetcode.first.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果n是3的倍数，输出“Fizz”；
 * 2. 如果n是5的倍数，输出“Buzz”；
 * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {
    public static void main(String[] args) {
      fizzBuzz(15);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            if (num % 3 == 0 && num % 5 == 0) {
                list.add("FizzBuzz");
            } else if (num % 3 == 0) {
                list.add("Fizz");
            } else if (num % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(num + "");
            }
        }
        return list;
    }
}

package me.weey.leetcode.first.linkedlist;

import java.util.ArrayList;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.linkedlist
 * @description:
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 输入：1->0->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @date 2020-02-24 23:22
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
//        listNode.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        //只有一条是正确的
        if (null == head || head.next == null) {
            return true;
        }

        ArrayList<Integer> number = new ArrayList<>();
        while (head != null) {
            number.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = number.size() - 1; i < number.size() / 2; i++, j--) {
            if (!number.get(i).equals(number.get(j))) {
                return false;
            }
        }

        return true;
    }
}

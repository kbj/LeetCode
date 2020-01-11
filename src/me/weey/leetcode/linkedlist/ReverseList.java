package me.weey.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.linkedlist
 * @description: 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @date 2019-12-01 18:19
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode1);
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ArrayList<Integer> intList = new ArrayList<>();
        while (head != null) {
            intList.add(head.val);
            head = head.next;
        }

        ListNode first = new ListNode(intList.get(intList.size() - 1));
        ListNode theFirst = first;
        for(int i=intList.size() - 2; i>=0; i--) {
            first.next = new ListNode(intList.get(i));
            first = first.next;
        }

        return theFirst;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

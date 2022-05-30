package me.weey.leetcode.first.linkedlist;


/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.linkedlist
 * @description:
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2020-01-25 12:19
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(5);
//        one.next = new ListNode(2);
//        one.next.next = new ListNode(4);

        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(null, two);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode head = null;

        while (null != l1 || null != l2) {
            if (null != l1 && null != l2) {
                if (l1.val != l2.val) {
                    //比较之中小的值
                    int min;
                    if (l1.val < l2.val) {
                        min = l1.val;
                        l1 = l1.next;
                    } else {
                        min = l2.val;
                        l2 = l2.next;
                    }

                    //添加到链表中
                    if (null == listNode) {
                        listNode = new ListNode(min);
                        head = listNode;
                    } else {
                        listNode.next = new ListNode(min);
                        listNode = listNode.next;
                    }
                } else {
                    //两个值相等的话两个值都加入链表
                    if (null == listNode) {
                        listNode = new ListNode(l1.val);
                        head = listNode;
                    } else {
                        listNode.next = new ListNode(l1.val);
                        listNode = listNode.next;
                    }
                    listNode.next = new ListNode(l2.val);
                    listNode = listNode.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            } else if (null != l1) {
                if (null == listNode) {
                    listNode = new ListNode(l1.val);
                    head = listNode;
                } else {
                    listNode.next = new ListNode(l1.val);
                    listNode = listNode.next;
                }
                l1 = l1.next;
            } else {
                if (null == listNode) {
                    listNode = new ListNode(l2.val);
                    head = listNode;
                } else {
                    listNode.next = new ListNode(l2.val);
                    listNode = listNode.next;
                }
                l2 = l2.next;
            }
        }

        return head;
    }
}

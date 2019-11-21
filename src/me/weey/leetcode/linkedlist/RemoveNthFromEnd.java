package me.weey.leetcode.linkedlist;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.linkedlist
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * @date 2019-11-21 18:05
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //从前一位开始定义
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode two = dummy;

        //定义一个指针指向开头，以及另外一个指向开头+n处
        for (int i = 0; i <= n; i++) {
            two = two.next;
        }

        //当最先的指针停止时后一位的指针的下一位就是倒数的指针
        while (two != null) {
            two = two.next;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

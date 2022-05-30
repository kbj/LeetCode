package me.weey.leetcode.first.linkedlist;

/**
 * @author Weey
 * @program: Leetcode
 * @package me.weey.leetcode.first.linkedlist
 * @description:
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
 *
 * @date 2020-03-02 10:48
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        //头指针走两步，尾指针走一步，判断是否会出现相同情况，有相同代表是有环
        ListNode pre = head;
        ListNode end = head;

        while (pre != null && pre.next != null) {
            pre = pre.next.next;
            end = end.next;
            if (pre == end) {
                return true;
            }
        }

        return false;
    }
}

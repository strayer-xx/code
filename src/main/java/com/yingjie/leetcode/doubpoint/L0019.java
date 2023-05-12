package com.yingjie.leetcode.doubpoint;

/**
 * <p>Title: L0098</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/12/1 1:17
 */
public class L0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0, head);
        ListNode fast = virtual, slow = virtual;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtual.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

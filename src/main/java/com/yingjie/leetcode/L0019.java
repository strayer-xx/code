package com.yingjie.leetcode;

/**
 * <p>Title: L</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/12/1 1:17
 */
public class L0019 {

    public L0024.ListNode removeNthFromEnd(L0024.ListNode head, int n) {
        L0024.ListNode virtual = new L0024.ListNode(0, head);
        L0024.ListNode fast = virtual, slow = virtual;
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
}

package com.yingjie.leetcode;

/**
 * <p>Title: L0206</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/29 14:35
 */
public class L0206 {

    public static void main(String[] args) {
        L0206 solution = new L0206();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        solution.reverseList1(head);
    }

    /**
     * 双指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode preTemp = pre, curTemp = cur;
            pre = cur;
            cur = cur.next;
            curTemp.next = preTemp;
        }
        return pre;
    }

    /**
     * 着重理解
     * 递归
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

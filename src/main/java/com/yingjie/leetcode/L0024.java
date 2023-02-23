package com.yingjie.leetcode;

/**
 * <p>Title: L0024</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/30 23:50
 */
public class L0024 {

    /***
     * 递归
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

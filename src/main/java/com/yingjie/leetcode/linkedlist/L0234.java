package com.yingjie.leetcode.linkedlist;


/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class L0234 {

    public static void main(String[] args) {
        new L0234().isPalindrome(new ListNode(1, new ListNode(1, new ListNode(1, null))));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        mid = reverseList(mid.next);
        return isSame(head, mid);
    }

    // 寻找中间节点
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 翻转链表
    private ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private boolean isSame(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2;
        while(p2!=null){
            if(p1.val!=p2.val) return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

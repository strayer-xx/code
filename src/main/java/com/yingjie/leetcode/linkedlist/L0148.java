package com.yingjie.leetcode.linkedlist;

/**
 * <p>Title: L0148</p>
 * <p>Description: 排序链表</p>
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 */
public class L0148 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 归并排序（链表常用的排序方法）
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next.next, l, r;
        // 快慢指针找出中位数
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 对右半部分进行归并排序
        r = mergeSort(slow.next);
        // 链表判断结束的标志：末尾节点.next==null
        slow.next=null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 有序链表合并
    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                temp.next = l;
                l = l.next;
            }else {
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        if (l != null) {
            temp.next = l;
        }
        if (r != null) {
            temp.next = r;
        }
        return head.next;
    }

    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null) return head;
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead,null);
    }
    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head,ListNode end){
        if (head == end || head.next == end || head.next.next == end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead = new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition = head.next, p = partition, tp = tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next != end){
            if (p.next.val < partition.val){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next = tmpHead.next;
        quickSort(head, partition);
        quickSort(partition, end);
        // 返回结果时去除头节点
        return head.next;
    }
}

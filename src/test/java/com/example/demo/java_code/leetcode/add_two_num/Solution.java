package com.example.demo.java_code.leetcode.add_two_num;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/10
 * </p>
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num;
        int advance = 0;
        ListNode l3 = null;
        ListNode last = null;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + advance;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            num = sum > 9 ? sum - 10 : sum;
            advance = sum > 9 ? 1 : 0;
            final ListNode l = last;
            final ListNode newNode = new ListNode(num);
            if (l == null) {
                l3 = newNode;
            } else {
                l.next = newNode;
            }
            last = newNode;
        }
        if (advance == 1) {
            last.next = new ListNode(1);
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(3);
        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        System.out.println(l3.val + "-" + l3.next.val + "-" + l3.next.next.val);
    }
}

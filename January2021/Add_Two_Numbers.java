/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the 
two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3601/
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1!=null || l2!=null) {
            int x = l1!=null ? l1.val : 0;
            int y = l2!=null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        if(carry>0)
            current.next = new ListNode(carry);
        return dummy.next;
    }
}

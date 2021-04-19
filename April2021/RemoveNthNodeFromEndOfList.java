/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       int length  = 0;
       ListNode first = head;
       while (first != null) {
        length++;
        first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
        length--;
        first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}

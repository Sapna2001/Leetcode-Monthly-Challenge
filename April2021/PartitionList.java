/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3707/
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode small = head1;
        ListNode large = head2;  
        ListNode current = head;
        while(current != null) {
            if(x > current.val) {
                small.next = current;
                small = current;
            } else {
               large.next = current;
               large = current; 
            }
            current = current.next;
        }
        large.next = null;
        small.next = head2.next;
        return head1.next;
    }
}

// TC: O(n)

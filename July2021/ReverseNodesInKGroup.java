/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the 
end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3818/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        int totalNodes = 0;
        ListNode current = head;
        
        while(current != null) {
            totalNodes++;
            current = current.next;
        }
        
        current = head;
        ListNode next = null;
        ListNode prev = dummy;
        
        while(totalNodes >= k) {
            current = prev.next;
            next = current.next;
            
            for(int i = 1; i < k ; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            
            prev = current;
            totalNodes -= k;
        }
        return dummy.next;
    }
}

/*
TC: O(n)
SC: O(1)
*/

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only 
nodes themselves may be changed.)

Link: https://leetcode.com/problems/swap-nodes-in-pairs/
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode(0), previous = dummy, current = head;
        dummy.next = head;
        
        while(current != null && current.next != null) {
            previous.next = current.next;
            current.next = current.next.next;
            previous.next.next = current;
            current = current.next;
            previous = previous.next.next;
        }
        
        return dummy.next;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

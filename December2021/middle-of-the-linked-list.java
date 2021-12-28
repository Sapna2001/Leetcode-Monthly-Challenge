/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Link: https://leetcode.com/problems/middle-of-the-linked-list/
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}

/*
Two pointer approach
Time Complexity: O(N)
Space Complexity: O(1)
*/

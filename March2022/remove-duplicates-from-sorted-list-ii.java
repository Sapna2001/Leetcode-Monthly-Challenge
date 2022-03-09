/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list 
sorted as well.

Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode current = head;
        ListNode previous = result;
        
        while(current != null) {
            if(current.next != null && current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                previous.next = current.next;
            } else {
                previous = current;
            }
            
            current = current.next;
        }
        
        return result.next;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used 
to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Link: https://leetcode.com/problems/linked-list-cycle-ii/
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (!(fast != null && fast.next != null)) {
            return null;
        }
        
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        
        return head;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

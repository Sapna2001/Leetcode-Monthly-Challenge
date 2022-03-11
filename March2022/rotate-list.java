/*
Given the head of a linked list, rotate the list to the right by k places.

Link: https://leetcode.com/problems/rotate-list/
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }    
        
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        
        temp.next = head;
        
        k = k % length;
        int headNode = length - k;
        while(headNode-- > 0) {
            temp = temp.next;
        }
        
        head = temp.next;
        temp.next =  null;
        
        return head;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Link: https://leetcode.com/problems/remove-linked-list-elements/
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode current = node;
        
        while(current.next != null) {
            if(current.next.val == val) {
                current.next = current.next.next;   
                continue;
            }
            current = current.next;   
        }
        
        return node.next;
    }
}

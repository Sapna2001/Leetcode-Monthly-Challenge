/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary 
representation of a number.

Return the decimal value of the number in the linked list.

Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
*/

class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int no = 0;
        
        while(temp != null) {
            no = (2 * no) + temp.val;
            temp = temp.next;
        }
        
        return no;
    }
}

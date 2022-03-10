/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
Link: https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        
        while(temp1 != null && temp2 != null) {
            int val1 = temp1.val;
            int val2 = temp2.val;
            int sum = val1 + val2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        while(temp1 != null) {
            int sum = temp1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp1 = temp1.next; 
            temp = temp.next;
        }
        
        while(temp2 != null) {
            int sum = temp2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        if(carry != 0) {
            ListNode node = new ListNode(carry);   
            temp.next = node;
        }
        
        return result.next;
    }
}

/*
Time Complexity: O(max(n1,n1))
Space Complexity: O(max(n1,n1) + 1)
*/

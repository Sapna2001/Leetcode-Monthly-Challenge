/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Link: https://leetcode.com/problems/merge-two-sorted-lists/
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        
        while(temp1 != null && temp2 != null) {
            if(temp1.val > temp2.val) {
                int val = temp2.val;
                temp.next = new ListNode(val);
                temp2 = temp2.next;

            } else {
                int val = temp1.val;
                temp.next = new ListNode(val);
                temp1 = temp1.next;
            } 
            temp = temp.next;
        }
        
        while(temp1 != null) {
            int val = temp1.val;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp1 = temp1.next;
            temp = temp.next;
        }
        
        while(temp2 != null) {
           int val = temp2.val;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp2 = temp2.next;
            temp = temp.next;
        }
        
        return result.next;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

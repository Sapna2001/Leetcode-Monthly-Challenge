/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted 
as well.
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
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
    public ListNode deleteDuplicates(ListNode head) {
     if(head == null) 
         return null;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode current = dummy;
      while(current.next!=null && current.next.next!=null) {
          if(current.next.val == current.next.next.val) {
              int val = current.next.val;
              while(current.next!=null && current.next.val==val) {
                  current.next = current.next.next;
              }
          } else {
              current = current.next;
          }
      }
        return dummy.next;
    }
}

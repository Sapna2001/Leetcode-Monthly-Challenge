/*
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One 
element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

Link: https://leetcode.com/problems/insertion-sort-list/
*/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;     
        }
        
        ListNode dummy = new ListNode(-5001);
        ListNode preInsertionNode, toInsertNode;
        dummy.next = head;
        ListNode currentIterator = head;
        
        while(currentIterator != null && currentIterator.next != null) {
            if(currentIterator.val <= currentIterator.next.val) {
                currentIterator = currentIterator.next;    
            } else {
                toInsertNode = currentIterator.next;
                preInsertionNode = dummy;
                while(preInsertionNode.next.val < toInsertNode.val) {
                    preInsertionNode = preInsertionNode.next;    
                }
                currentIterator.next = toInsertNode.next;
                toInsertNode.next = preInsertionNode.next;
                preInsertionNode.next = toInsertNode;
            }
        }
        
        return dummy.next;
    }
}

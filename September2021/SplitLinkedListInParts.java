/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3992/
*/
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int totalLength = 0;
        ListNode iterator = head;
        
        while(iterator != null) {
            totalLength++;
            iterator = iterator.next;
        }
        
        int minLength = totalLength / k, left = totalLength % k;
        ListNode node = head, previous = null;
        
        int i = 0;
        
        while(node!= null && i < k) {
            result[i] = node;
            
            for(int j = 0 ; j < minLength + (left > 0 ? 1 : 0) ; j++) {
                previous = node;
                node = node.next;
            }
            
            previous.next = null;
            i++;
            left--;
        }
        
        return result;
    }
}

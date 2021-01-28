/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3615/

*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return helperFunction (lists, 0 ,lists.length - 1);      
    }
    
    public ListNode helperFunction(ListNode[] lists, int low, int high) {
        if(low > high)
            return null ;
        else if(low == high) {
            return lists[low];
        } else {
            int mid = (low+high)/2;
            ListNode left = helperFunction(lists, low, mid);
            ListNode right = helperFunction(lists, mid+1, high);
            return merge(left,right);
        }
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        if(left==null)
            return right;
        if(right==null)
            return left;
        ListNode dummy = new ListNode();
        ListNode t = dummy;
        while(left!=null && right!=null) {
            if(left.val>right.val) {
                t.next = right;
                t = t.next;
                right = right.next; 
            } else {
                t.next = left;
                t = t.next;
                left = left.next; 
            }
        }
        while(left!=null) {
            t.next = left;
            t = t.next;
            left = left.next; 
        }
        while(right!=null) {
             t.next = right;
             t = t.next;
             right = right.next; 
        }
        return dummy.next;
    }
    // TC : klog(k)
}

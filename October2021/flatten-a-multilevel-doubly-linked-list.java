/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate 
doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
	public Node flatten(Node head) {
		if(head == null){
			return head;
		}

		Node iterator = head;
		while(iterator != null){
			if(iterator.child != null){
				Node next = iterator.next;
				iterator.next = flatten(iterator.child);
				iterator.next.prev = iterator;
				iterator.child =null;

				while(iterator.next != null){
					iterator=iterator.next;
				}

				if(next!=null){
					iterator.next = next;
					iterator.next.prev = iterator;
				}
			}
            
			iterator = iterator.next;
		}
		return head;
	}
}


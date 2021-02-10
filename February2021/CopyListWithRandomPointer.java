/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original 
node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the 
same list state. None of the pointers in the new list should point to nodes in the original list.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3635/
*/

class Solution {
    public Node copyRandomList(Node head) {
        // hashmap
        // TC and SC = O(n)
        Node copy = new Node(-1);
        Node node = copy;
        Map<Node,Node> map = new HashMap<>();
        
        while(head!=null) {
            node.next = new Node(head.val);
            node.next.random = head.random;
            map.put(head,node.next);
            head = head.next;
            node = node.next;
        }
        
        node = copy.next;
        
        while(node!=null) {
            node.random = map.get(node.random);
            node = node.next;
        }
        
        return copy.next;
    }
    
    class Solution {
    // TC : O(N)
    // SC : O(1)
    public Node copyRandomList(Node head) {
    // copy node in the middle of linked list
    Node iterator = head;
    Node front = head;
    
    while(iterator!= null) {
        front = iterator.next;
        Node copy = new Node(iterator.val);
        iterator.next = copy;
        copy.next = front;
        iterator = front;     
    }
    
    // point random
    iterator = head;
    while(iterator!=null) {
        if(iterator.random!=null)
            iterator.next.random = iterator.random.next;
        iterator = iterator.next.next;
    }
    
    // separate copy and oiginal
     iterator = head;
     Node pseudoHead = new Node(0);
     Node copy = pseudoHead;
    
     while(iterator!=null) {
         front = iterator.next.next;
         copy.next = iterator.next;
         iterator.next = front;
         iterator = front;
         copy = copy.next;
     }

    
    return pseudoHead.next;
    }
}
}

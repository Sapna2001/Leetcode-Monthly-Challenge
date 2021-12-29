/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/

class Solution {
    public Node connect(Node root) {
        // Base condition
        if(root == null) {
            return root;
        }
        if(root.left != null) {
            if(root.next != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;    
            }
            
            root.left.next = root.right;
            connect(root.left);
            connect(root.right);
        }
        
        return root;
    }
}

/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right 
has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
*/

class Solution {
    private int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }
    
    private TreeNode bstHelper (int[] preorder, int start, int end) {
        if(index == preorder.length || preorder[index] < start || preorder[index] > end) {
            return null;
        }
        
        int value = preorder[index++];
        TreeNode node = new TreeNode(value);
        node.left = bstHelper(preorder, start, value);   
        node.right = bstHelper(preorder, value, end);  
        return node;
    }
}

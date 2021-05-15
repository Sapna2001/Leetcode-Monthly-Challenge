/*
Given the root of a binary tree, flatten the tree into a "linked list":

- The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
- The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3742/
*/

class Solution {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        preOrderTraversal(root);
    }
    
    TreeNode preOrderTraversal(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode leftChild = preOrderTraversal(root.left);
        TreeNode rightChild = preOrderTraversal(root.right);
        
        TreeNode extremeRightOfLeftChild = leftChild;
        while(extremeRightOfLeftChild != null && extremeRightOfLeftChild.right != null)
            extremeRightOfLeftChild = extremeRightOfLeftChild.right;
        
        if(extremeRightOfLeftChild != null) {
            extremeRightOfLeftChild.right = rightChild;
            root.right = leftChild;
        }
        
        root.left = null;
        return root;
        
    } 
}

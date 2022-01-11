/*
You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant 
bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.

Link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
*/

class Solution {
    private int sumRootToLeaf = 0;
    
    private void preorder(TreeNode root, int currentNumber) {
        if(root != null) {
            currentNumber = (currentNumber << 1) | root.val;
            
            if(root.left == null && root.right == null) {
                sumRootToLeaf += currentNumber;   
            }
            
            preorder(root.left, currentNumber);
            preorder(root.right, currentNumber);
        }    
    }
    
    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return sumRootToLeaf;
    }
}

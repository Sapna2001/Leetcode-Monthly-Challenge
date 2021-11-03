/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
*/

class Solution {
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        
        return totalSum;
    }
    
    private void helper(TreeNode root, int val) {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            totalSum += val * 10 + root.val;
            return;
        }
        
        helper(root.left, val * 10 + root.val);
        helper(root.right, val * 10 + root.val);    
    }
}

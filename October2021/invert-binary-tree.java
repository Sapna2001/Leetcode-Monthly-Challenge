/*
Given the root of a binary tree, invert the tree, and return its root.

Link: https://leetcode.com/problems/invert-binary-tree/
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
			return null;
		}
        
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
        
		root.right = left;
		root.left =right;
        
		return root;    
    }
}

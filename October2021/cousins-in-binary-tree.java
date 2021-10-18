/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values 
x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Link: https://leetcode.com/problems/cousins-in-binary-tree/
*/

class Solution {
    private int xDepth = -1;
	private int yDepth = -2;

	private TreeNode xParent = null;
	private TreeNode yParent = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
			return false;

		helper(root, x, y, 0, null);
		return xDepth == yDepth && xParent != yParent;    
    }
    
    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent) {
		if (root == null) {
			return;
		} else if (root.val == x) {
			xParent = parent;
			xDepth = depth;
		} else if (root.val == y) {
			yParent = parent;
			yDepth = depth;
		} else {
			helper(root.left, x, y, depth + 1, root);
			helper(root.right, x, y, depth + 1, root);
		}
	}
}

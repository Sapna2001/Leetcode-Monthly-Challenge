/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

Link: https://leetcode.com/problems/delete-node-in-a-bst/
*/

class Solution {
    private int maxLeft(TreeNode root) {
        if(root.right != null) {
            return maxLeft(root.right);
        } else {
            return root.val;
        }    
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }   
        
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int leftMax = maxLeft(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left, leftMax);
                return root;
            }
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
}

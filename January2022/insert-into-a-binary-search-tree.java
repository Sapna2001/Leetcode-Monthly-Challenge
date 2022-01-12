/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is 
guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        
        if(root == null) {
            return newNode;
        } 
        
        TreeNode currentNode = root;
        while(true) {
            if(currentNode.val <= val) {
                if(currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    break;
                }   
            } else {
                if(currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = newNode;
                    break;
                } 
            }
        }
        
        return root;
    }
}


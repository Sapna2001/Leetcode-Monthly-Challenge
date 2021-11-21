/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and 
return the binary tree.

Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
*/

class Solution {
    private TreeNode helperMethod(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if((inorderStart > inorderEnd) || (postorderStart > postorderEnd)) {
            return null;
        }  
        
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int rootIndex = 0;
        for(int i = 0 ; i < inorder.length ; i++) {
            if(inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        
        root.left = helperMethod(inorder, inorderStart, rootIndex - 1, postorder, postorderStart, postorderStart + rootIndex - inorderStart - 1 );    
        root.right = helperMethod(inorder, rootIndex + 1, inorderEnd, postorder, postorderStart + rootIndex - inorderStart, postorderEnd - 1);    
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helperMethod(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);    
    }
}

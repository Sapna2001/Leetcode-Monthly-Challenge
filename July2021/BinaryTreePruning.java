/*
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) 
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(canDeleteNode(root))
            return null;
        return root;
    }
    
    // node zero, children should be null
    public boolean canDeleteNode(TreeNode root) {
        if(root.val == 0 && root.left == null && root.right == null)
            return true;
        return false;
    }
}
/*
TC: O(n)
SC: O(logn) -> Height of the tree
*/

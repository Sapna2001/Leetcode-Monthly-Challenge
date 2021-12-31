/*
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/
*/

class Solution {
    private int result = 0;
    
    private void helperFunction(TreeNode node, int currentMax, int currentMin) {
        if(node == null) {
            return;
        }    
        
        int differenceWithMaxValue = Math.abs(currentMax - node.val);
        int differenceWithMinValue = Math.abs(currentMin - node.val);
        int possibleResult = Math.max(differenceWithMaxValue, differenceWithMinValue);
        
        result = Math.max(result, possibleResult);
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        
        helperFunction(node.left, currentMax, currentMin);
        helperFunction(node.right, currentMax, currentMin);
        return;
    }
    
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }   
        
        helperFunction(root, root.val, root.val);
        return result;
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

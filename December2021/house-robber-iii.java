/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will 
automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

Link: https://leetcode.com/problems/house-robber-iii/
*/

class Solution {
    Map<TreeNode, Integer> map = new HashMap();
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }   
        
        if(map.containsKey(root)) {
            return map.get(root);
        }
        
        int val = 0;
        if(root.left != null) {
            val += rob(root.left.left) + rob(root.left.right); 
        }
        if(root.right != null) {
            val += rob(root.right.left) + rob(root.right.right); 
        }
        
        map.put(root, Math.max((root.val + val), (rob(root.left) + rob(root.right))));
                
        return map.get(root);
    }
}

/*
Time Complexity : O(n)
Space Complexity. : O(n)
*/

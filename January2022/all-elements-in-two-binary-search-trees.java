/*
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void inorder(TreeNode root, List<Integer> arrayList) {
        if(root == null) {
            return ;
        }
        
        inorder(root.left,arrayList);
        arrayList.add(root.val);
        inorder(root.right,arrayList);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arrayList1 = new ArrayList<Integer>();
        List<Integer> arrayList2 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        inorder(root1, arrayList1);
        inorder(root2, arrayList2);
                
        int i = 0, j = 0;
        while(i < arrayList1.size() && j < arrayList2.size()) {
            int num1 = arrayList1.get(i), num2 = arrayList2.get(j);
            if(num1 < num2) {
                result.add(num1);
                i++;
            } else {
                result.add(num2);
                j++;
            }
        }
                
        while(i < arrayList1.size()) {
            int num1 = arrayList1.get(i);
            result.add(num1);
            i++;    
        }
                
        while(j < arrayList2.size()) {
            int num2 = arrayList2.get(j);
            result.add(num2);
            j++;    
        }
        
        return result;
    }
}

/*
Time Complexity: O(m + n)
Space Complexity: O(m + n)
*/

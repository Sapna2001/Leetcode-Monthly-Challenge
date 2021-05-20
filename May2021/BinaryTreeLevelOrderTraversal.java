/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3749/
*/

class Solution {
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
     
        bfs(root, result, new ArrayList<Integer>());
        return result;
    }
    
    private void bfs(TreeNode root, List<List<Integer>> result, List<Integer> temp) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 1; i <= size; ++i) {
                TreeNode current = queue.pollFirst();
                if(current.left != null) {
                    queue.offerLast(current.left);
                }
                
                if(current.right != null) {
                    queue.offerLast(current.right);
                }
                
                temp.add(current.val);
            }

            result.add(new ArrayList<Integer>(temp));
            temp.clear();
        }
    }
}

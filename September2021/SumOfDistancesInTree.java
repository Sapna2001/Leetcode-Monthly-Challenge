/*
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3963/
*/

class Solution {
    private int[] result;
    private int[] count;
    private List<HashSet<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        result = new int[n];
        count = new int[n];
        
        for (int i = 0; i < n ; ++i)
            tree.add(new HashSet<Integer>());
        
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1);
        return result;   
    }
    
    public void postOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre)
                continue;
            
            postOrder(i, root);
            count[root] += count[i];
            result[root] += result[i] + count[i];
        }
        count[root]++;
    }


    public void preOrder(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) 
                continue;
            
            result[i] = result[root] - count[i] + count.length - count[i];
            preOrder(i, root);
        }
    }
}

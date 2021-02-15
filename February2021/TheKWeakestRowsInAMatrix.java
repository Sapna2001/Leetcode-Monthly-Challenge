/*

Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to 
the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. 
Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/

*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<int[]> customCompare = new Comparator<int[]>(){

            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                } else{
                    return b[0] - a[0];
                }
            }
        };
        // count, index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(customCompare);;
        
        // TC : O(mn)
        for(int i = 0 ; i < mat.length ; i++) {
            int[] row = mat[i];
            int countOnes = getCount(row);
            priorityQueue.offer(new int[]{countOnes,i});
            if(priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }
        
        int[] ans = new int[k];
        int i = k-1;
        while(!priorityQueue.isEmpty()) {
            ans[i] = priorityQueue.poll()[1];
            i--;
        }
        return ans;
    }
    
    // TC : O(N)
    // binary search TC : log(n)
    public int getCount(int[] row) {
        int count = 0;
        for(int i : row)
            count+=i;
        return count;
    }
    // m : no of rows
    // SC : O(k)
    // TC : mlogk + mn
}

/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Link: https://leetcode.com/problems/find-the-town-judge/
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inwardDegree = new int[n + 1];   
        int[] outwardDegree = new int[n + 1];
        
        for(int i = 0 ; i < trust.length ; i++) {
            int countOut = outwardDegree[trust[i][0]];
            outwardDegree[trust[i][0]] = countOut + 1;
            int countIn = inwardDegree[trust[i][1]];
            inwardDegree[trust[i][1]] = countIn + 1;
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if((outwardDegree[i] == 0) && (inwardDegree[i] == n - 1)) {
                return i;
            }
        }
        
        return -1;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

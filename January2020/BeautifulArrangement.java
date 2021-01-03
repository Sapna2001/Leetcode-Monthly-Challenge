/*
Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.

Given an integer n, return the number of the beautiful arrangements that you can construct.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/
*/

class Solution {
    int count=0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        permute(n,1,visited);
        return count;
    }
    void permute(int n, int pos, boolean[] visited){
        if(pos>n)
            count++;
        for(int i=1; i<=n;i++){
            if(!visited[i] && ((pos%i==0)||(i%pos==0))){
                visited[i]=true;
                permute(n,pos+1,visited);
                visited[i]=false;
            }
        }
    }
}

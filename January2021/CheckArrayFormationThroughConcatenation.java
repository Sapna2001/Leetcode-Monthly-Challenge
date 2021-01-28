/*
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the 
arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

Link - https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/
Map sould be used and searching in a map is O(1)

// O(n) as iterating through all the elements
// O(no:of pieces)
*/

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // map created
        Map<Integer, int[]> map = new HashMap<>();
        // first element in piece is a key
        for(int[] piece : pieces)
            map.put(piece[0],piece);
        int start = 0;
        while(arr.length>start){
            if(map.containsKey(arr[start])){
                int[] pieceArray = map.get(arr[start]);
                for(int i=0;i<pieceArray.length;i++){
                    if(arr[start]!=pieceArray[i])
                        return false;
                    else
                        start++;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

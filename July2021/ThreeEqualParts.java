/*
You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the 
same binary value.

If it is possible, return any [i, j] with i + 1 < j, such that:

arr[0], arr[1], ..., arr[i] is the first part,
arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
All three parts have equal binary values.
If it is not possible, return [-1, -1].

Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are 
allowed, so [0,1,1] and [1,1] represent the same value.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3817/
*/

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] ans = new int[]{-1,-1};
        int count1 = 0;
        
        // count 1s
        for(int i : arr) {
            count1 += i;
        }
        if(count1 == 0) {
            return new int[]{0,2};
        }
        if(count1 % 3 != 0)
            return ans;
        
        int noOfOnesInEachPart = count1 / 3;
        int indexOfFirstOneinPart0 = -1;
        int indexOfFirstOneinPart1 = -1;
        int indexOfFirstOneinPart2 = -1;
        
        count1 = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 1) {
                count1++;
                if(count1 == noOfOnesInEachPart + 1) {
                    indexOfFirstOneinPart1 = i;
                } else if(count1 == 2 * noOfOnesInEachPart + 1) {
                    indexOfFirstOneinPart2 = i;
                } else if(count1 == 1)  {
                    indexOfFirstOneinPart0 = i;
                }
            }
        }
        
        while(indexOfFirstOneinPart2 < arr.length) {
            if(arr[indexOfFirstOneinPart0] == arr[indexOfFirstOneinPart1] && arr[indexOfFirstOneinPart0] == arr[indexOfFirstOneinPart2]) {
               indexOfFirstOneinPart0++; 
               indexOfFirstOneinPart1++; 
               indexOfFirstOneinPart2++; 
            } else {
                return ans; 
            }
        }
        
        return new int[]{indexOfFirstOneinPart0 - 1, indexOfFirstOneinPart1};
    }
}

/*
TC: O(n)
SC:O(1)
*/

/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Input: arr = [2,1]
Output: false

Input: arr = [3,5,5]
Output: false

Input: arr = [0,3,2,1]
Output: true

Input: arr = [9,8,7,6,5,4,3,2,1,0]
Output: false
*/

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3)
            return false;
        int i = 0;
        boolean result = false;
        while(true && i<arr.length-1){
            if(arr[i+1]>arr[i])
                i++;
            else if(arr[i+1]==arr[i])
                return false;
            else{
                if(i!=0)
                    result = true;
                else
                    result = false;
                break;
            }
        }
        while(true && i<arr.length-1){
            if(arr[i]>arr[i+1])
                i++;
            else if(arr[i+1]==arr[i])
                return false;
            else 
                break;
        }
        System.out.println(result+" "+i);
        return (result==true) && (i==arr.length-1);
    }
}

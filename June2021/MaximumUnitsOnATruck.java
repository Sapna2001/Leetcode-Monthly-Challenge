/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long 
as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3778/
*/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int maxUnits = 0;
        for(int[] box : boxTypes) {
            int noOfBoxes = box[0];
            int noOfUnits = box[1];
            
            if(truckSize >= noOfBoxes) {
                maxUnits += (noOfBoxes * noOfUnits);
                truckSize -= noOfBoxes;
            } else {
                maxUnits += truckSize * noOfUnits;
                return maxUnits;
            }
        }
        return maxUnits;
    }
}

/*
TC : O(nlogn)
SC: O(1)
*/

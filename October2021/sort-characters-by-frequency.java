/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the 
string.

Return the sorted string. If there are multiple answers, return any of them.

Link: https://leetcode.com/problems/sort-characters-by-frequency/
*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}   
        
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> 
                                                                                                           (b.getValue() - a.getValue()));
        
        priorityQueue.addAll(map.entrySet());
        
		String result = "";
        
		while (!priorityQueue.isEmpty()) {
			Map.Entry<Character, Integer> head = priorityQueue.poll();
			int frequency = head.getValue();
			while (frequency-- > 0) {
				result += head.getKey();
			}
		}
        
		return result;
    }
}

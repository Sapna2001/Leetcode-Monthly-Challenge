/*
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.
Link : https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3598/
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        HashMap<String,Boolean> visitedMap = new HashMap<String,Boolean>();
        
        for(int i=0; i<wordList.size();i++)
            visitedMap.put(wordList.get(i),false);
        
        Queue<String> queue = new LinkedList<String>();
        int length = 1;
        queue.add(beginWord);
        visitedMap.put(beginWord,true);
        
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0; i<size;i++){
                System.out.println(queue);
                String check = queue.poll();
                if(check.equals(endWord))
                    return length;
                wordMatch(check,visitedMap,queue);
            }
             length++;
        }
         return 0;
    }
    
    public void wordMatch(String check,HashMap<String,Boolean> visitedMap,Queue<String> queue ) {
        for(int i=0;i<check.length();i++){
            char[] checkArray = check.toCharArray();
            for(int j=0;j<26;j++){
                char ch = (char)('a'+j);
                checkArray[i] = ch;
                String newWord =String.valueOf(checkArray);
                if(visitedMap.containsKey(newWord) && !visitedMap.get(newWord)){
                    queue.add(newWord);
                    visitedMap.put(newWord,true);
                }
            }
        }
    }
}

/*
Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] 
is a palindrome.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/
*/

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap();
        
        for(int i = 0 ; i < words.length ; i++)
            map.put(words[i],i);
        
        if (map.containsKey("")) {
            int emptyIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != emptyIndex && isPalindrome(words[i])) {
                    result.add(Arrays.asList(i, emptyIndex));
                    result.add(Arrays.asList(emptyIndex, i));
                }
            }
        }
        
        for(int i = 0 ; i < words.length ; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            Integer reversedIndex = map.get(reversed);
            if(reversedIndex != null && reversedIndex != i) 
                result.add(Arrays.asList(i,reversedIndex));    
        }
        
        for(int i = 0 ; i < words.length ; i++) {
            String currentWord = words[i];
            for(int cut = 1 ; cut < currentWord.length() ; cut++) {
                String leftCut = currentWord.substring(0,cut);
                String rightCut = currentWord.substring(cut);
                if(isPalindrome(leftCut)) {
                    String reversedRightPart = new StringBuilder(rightCut).reverse().toString();
                    if(map.containsKey(reversedRightPart))
                        result.add(Arrays.asList(map.get(reversedRightPart),i));    
                }
                if(isPalindrome(rightCut)) {
                    String reversedLeftPart = new StringBuilder(leftCut).reverse().toString();
                    if(map.containsKey(reversedLeftPart))
                        result.add(Arrays.asList(i,map.get(reversedLeftPart)));    
                }
            }
        }
        return result;                           
    }
                                   
    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while(left < right) 
            if(word.charAt(left++) != word.charAt(right--))
                return false;
        return true;
    }
}

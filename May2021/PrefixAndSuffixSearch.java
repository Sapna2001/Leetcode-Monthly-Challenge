/*
Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix. If there is more than one valid index, return 
the largest of them. If there is no such word in the dictionary, return -1.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/
*/

class WordFilter {
    HashMap<String, Integer> map = null;
    // O(N*l*l)
    public WordFilter(String[] words) {

        map = new HashMap<>();

        int index=0;
        for(String word: words){
            for(int i=0;i<=word.length();i++){
                for(int j=0;j<=word.length();j++){
                    String prefixAndSuffix = word.substring(0, i) + "#" + word.substring(j);

                    map.put(prefixAndSuffix, index);


                }
            }
            index++;
        }
    }

    // O(1)
    public int f(String prefix, String suffix) {
        String queryStr = prefix + "#" + suffix;
        return map.getOrDefault(queryStr, -1);
    }
}

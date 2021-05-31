/*
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord 
is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums
products.

Return list of lists of the suggested products after each character of searchWord is typed. 

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3762/
*/

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        TreeMap<String, Integer> map = new TreeMap<>();
        List<String> productList = Arrays.asList(products);
        
        for(int i = 0 ; i < products.length ; i++)
            map.put(products[i],i);
        
        String key = "";
        for(char c: searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "{");
            if(ceiling == null || floor == null)
                break;
            ans.add(productList.subList(map.get(ceiling), Math.min(map.get(ceiling)+3, map.get(floor)+1)));
        }
        while(ans.size() < searchWord.length())
            ans.add(new ArrayList<>());
        return ans;
    }
}

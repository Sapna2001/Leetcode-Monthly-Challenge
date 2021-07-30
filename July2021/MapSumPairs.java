/*
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3832/
*/

class MapSum {

    Map<String, Integer> map = null;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();    
    }
    
    public void insert(String key, int val) {
        map.put(key,val);    
    }
    
    public int sum(String prefix) {
        int total = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)) {
                total += entry.getValue();
            }
        }
        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

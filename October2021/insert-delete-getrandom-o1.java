/*
Implement the RandomizedSet class:

-> RandomizedSet() Initializes the RandomizedSet object.
-> bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
-> bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
-> int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each 
element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.

Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
*/

class RandomizedSet {

    Map<Integer, Integer> map = null;
    List<Integer> list = null;

    Random random = null;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();     
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }    
        return false;   
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            Integer lastNodeVal = list.get(list.size() - 1);

            if(lastNodeVal == val){
                list.remove(list.size() - 1);
                map.remove(new Integer(val));
                return true;
            }
            
            int indexOfVal = map.get(val);
            list.set(indexOfVal, lastNodeVal);
            map.put(lastNodeVal, indexOfVal);
            list.remove(list.size() - 1);
            map.remove(new Integer(val));
            return true;
        } 
        return false; 
    }
    
    public int getRandom() {
        int size = list.size();
        int index = random.nextInt(size);
        return list.get(index);    
    }
}

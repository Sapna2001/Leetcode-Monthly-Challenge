/*
Design the CombinationIterator class:

- CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a 
number combinationLength as arguments.
- next() Returns the next combination of length combinationLength in lexicographical order.
- hasNext() Returns true if and only if there exists a next combination.

Link: https://leetcode.com/problems/iterator-for-combination/
*/

class CombinationIterator {
    List<String> list = new ArrayList<>();
    int count = 0;
    
    public void permutation(String str, StringBuilder sb, int length, int index){
        if(sb.length() == length){
            list.add(sb.toString());
            return;
        }
        
        for(int i = index ; i < str.length() ; i++){
            sb.append(str.charAt(i));
            permutation(str, sb, length, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public CombinationIterator(String characters, int combinationLength) {
        permutation(characters, new StringBuilder(), combinationLength, 0);
    }
    
    public String next() {
        return list.get(count++);
    }
    
    public boolean hasNext() {
        return count < list.size();
    }
}

class Solution {
    List<String> result = new ArrayList<String>();
    
    public List<String> addOperators(String num, int target) {
        helper(0,"",0,0,num, target);
        return result;
    }
    
    private void helper(int i, String path, long resultSoFar, long previousNum, String num, int target) {
        if(i == num.length()) {
            if(resultSoFar == target)
                result.add(path);
            return;
        } 
        
        for(int j = i ; j < num.length() ; j++) {
            if(j > i && num.charAt(i) == '0') //leading zero 
                break;
            long currentNum = Long.parseLong(num.substring(i, j+1));
            if(i == 0)
                helper(j + 1, path + currentNum, currentNum, currentNum, num, target);
            else {
                helper(j + 1, path + "+" + currentNum, resultSoFar + currentNum, currentNum, num, target);
                helper(j + 1, path + "-" + currentNum, resultSoFar - currentNum, -currentNum, num, target);
                helper(j + 1, path + "*" + currentNum, resultSoFar - previousNum + previousNum * currentNum, previousNum * currentNum, num, target);
            }
        }
    }
                
}

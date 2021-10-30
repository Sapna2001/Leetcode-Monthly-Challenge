/*
Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.

Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".

Link: https://leetcode.com/problems/longest-duplicate-substring/
*/

class Solution {
    String str;
    int len;
    
    private class SubStr {
        private int hash;
        private int off;
        
        public SubStr(int off, int hash) {
            this.off = off; 
            this.hash = hash;
            //System.out.println(off+" "+hash);
        }
        
        public int hashCode() {
            return this.hash;
        }
        
        public boolean equals(Object o) {
            SubStr x = (SubStr)o;
            if (x.off == this.off) {
                return true;
            }
            if (x.hash != this.hash) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                if (str.charAt(x.off + i) != str.charAt(this.off + i)) {
                    return false;
                }
            }
            return true;
        }
                    
        public int getOffset() {
            return this.off;
        }
        
        public String toString() {
            return str.substring(this.off, this.off+len);
        }
    }
    
                    
    private String checkDup(int len) {
        this.len = len;
        HashSet<SubStr> s = new HashSet();
        int hash = 0;
        int p = 1;
        
        for (int i = 0; i < len; i++) {
            p = p * 33;
            hash = hash * 33 + str.charAt(i);
        }
        s.add(new SubStr(0, hash));
        for (int i = len; i < str.length(); i++) {
            hash = hash * 33 - str.charAt(i-len)*p + str.charAt(i);
            SubStr ss = new SubStr(i-len+1, hash);
            if (s.contains(ss)) {
                return ss.toString();
            } else {
                s.add(ss);
            }
        }
        return null;
    }
                    
    
    public String longestDupSubstring(String s) {
        this.str = s;  
        String result = "";
        int str = 0;
        int length = s.length();
        while (str < length) {
            int m = (str + length) / 2;
            String temp = checkDup(m);
            if (temp != null) {
                result = temp;
                str = m + 1;
            } else {
                length = m;
            }
        }
        
        return result;
    }
}

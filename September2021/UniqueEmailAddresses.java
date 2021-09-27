/*
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3989/
*/

class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> sanitizedEmails = new HashSet<>();
        
        for(String email : emails) {
            String updatedEmail =  getSanitizeEmail(email);
            sanitizedEmails.add(updatedEmail);
        }
        
        return sanitizedEmails.size();
    }

    private String getSanitizeEmail(String email){
        String localName = "";

        int i = 0;
        
        while(i < email.length() && email.charAt(i) != '@') {
            if(email.charAt(i) == '.') {
                i++;
            } else if(email.charAt(i) == '+'){
                while(i < email.length() && email.charAt(i) != '@') {
                    i++;
                }
            } else {
                localName += email.charAt(i);
                i++;
            }
        }
        
        i++;
        
        String domain = "";
        
        while(i < email.length()) {
            domain += email.charAt(i);
            i++;
        }
        
        return localName + "@" + domain;
    }
}

/*
TC: O(Len(emails)* max(Len(Email))
SC: O(Len(emails)
*/

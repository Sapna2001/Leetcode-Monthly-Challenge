/*

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3629/

*/

class Solution {
    public String simplifyPath(String path) {        
        String[] list = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s: list) {
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals(".."))
                if(stack.size()>0)
                    stack.pop();
                else
                    continue;
            else stack.add(s);
        }
        return "/" + String.join("/", stack);
    }
}

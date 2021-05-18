/*
Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.

A group of duplicate files consists of at least two files that have the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3747/
*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String path : paths) {
            String[] directory = path.split(" ");
            String rootPath = directory[0];
            for(int i = 1 ; i < directory.length ; i++) {
                String content = directory[i].substring(directory[i].indexOf("("),directory[i].indexOf(")"));
                if(!map.containsKey(content)) 
                    map.put(content,new ArrayList<>());
                map.get(content).add(rootPath+"/"+directory[i].substring(0,directory[i].indexOf("(")));
            }
        }
        
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1)
                answer.add(entry.getValue());
        }
        return answer;
    }
}

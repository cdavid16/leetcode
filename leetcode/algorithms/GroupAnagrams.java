package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> dict = new HashMap<String, Integer>();
        List<List<String>> groups = new LinkedList<>();
        String tmp ="";
        for(String str : strs){
            tmp = sortWord(str);
            Integer index = -1;
            if(!dict.containsKey(tmp)){
                dict.put(tmp, groups.size());
                groups.add(new ArrayList<>());
            }
            index = dict.get(tmp);
            groups.get(index).add(str);    
        }
        
        return groups;
    }
    
    private String sortWord(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
}

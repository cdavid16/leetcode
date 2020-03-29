package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
       if(paragraph.length()>1000 || banned.length>100 || paragraph.length() ==0)
            return "";
        
        String mostCommon = "";
        paragraph=paragraph.replace("!"," ").replace("?"," ").replace("'"," ").replace(","," ").replace(";"," ").replace("."," ").toLowerCase(); //remove invalid characters
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> bannedWord = new HashSet<>();
        int occurrence = Integer.MIN_VALUE;
        
        for(String bannedW : banned)
        	bannedWord.add(bannedW.toLowerCase());
        
        bannedWord.add(" ");
        
        for(String word : paragraph.split(" ")) {
        	if(!bannedWord.contains(word) && word.length()>0) {
        		if(!map.containsKey(word))
            		map.put(word, 1);
            	else
            		map.put(word, map.get(word)+1);
        	}
        	
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue() > occurrence) {
        		mostCommon = entry.getKey();
        		occurrence = entry.getValue();
        	}
        }
        
        return mostCommon;
        
    }
}

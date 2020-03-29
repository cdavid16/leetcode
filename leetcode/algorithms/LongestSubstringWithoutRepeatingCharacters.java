package leetcode.algorithms;

import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters{

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1 )
            return s.length();

        HashSet<Character> set = new HashSet();
        int max = 0;
        int i=0, j=0, n=s.length();
        while (i < n && j < n) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

}

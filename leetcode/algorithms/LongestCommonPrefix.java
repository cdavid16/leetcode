package leetcode.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class LongestCommonPrefix {
     public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1 )
            return (strs.length==0?"":strs[0]);

        Stack prefix = new Stack<Character>();
        List<Integer> lengths = new LinkedList<>();
        for(String word: strs){
            lengths.add(word.length());
        }
        int minLength  = Collections.min(lengths);
        lengths = null;

        for(int i = 0; i<minLength; i++){
            for(int j = 0; j<strs.length; j++){
                if(j==0)
                    prefix.push(strs[j].charAt(i));
                else
                    if((int)strs[j].charAt(i) != (int)(char)prefix.peek()){
                        prefix.pop();
                        return this.prefix(prefix);
                    }


            }
        }

        if(prefix.size()==0)
            return "";

        return this.prefix(prefix);
    }

    private String prefix(Stack<Character> prefix){
        String str="";

        for(char c : prefix){
            str += Character.toString(c);
        }

        return str;
    }
}

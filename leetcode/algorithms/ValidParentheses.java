package leetcode.algorithms;

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;

        if(s.length()==0)
            return true;
        
        Stack<Integer> stack = new Stack<>();
        stack.push((int)s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            int ascii =(int)s.charAt(i);
            int diff = ascii - (stack.size()>0?stack.peek():0);

            if(diff >= 1 && diff <=3)
                stack.pop();
            else
                stack.add(ascii);
        }

        return stack.size()==0;
    }


}

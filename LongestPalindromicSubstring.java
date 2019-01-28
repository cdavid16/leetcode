class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() > 1000)
            throw new IllegalArgumentException("String is longer than 1000 characters");
        
        int chars = 0;
        int palSize = s.length();
        
        while(chars<s.length()){
            int qytWords = s.length()-palSize;            
            int toSubstr = 0;
            for(int i=0;i<=qytWords;i++){
                toSubstr = palSize + i;
                String substr = s.substring(i,toSubstr);
                if(isPalindrome(substr))
                    return substr;
            }
            chars++;
            palSize = s.length() - chars;
        }
        
        return "";
    }
    
    private boolean isPalindrome(String s){
        int begIndex = 0, lastIndex = s.length()-1;
        while(begIndex<=lastIndex){
            if(s.charAt(begIndex)!=s.charAt(lastIndex))
                return false;
                
            begIndex++;
            lastIndex--;
            
        }
        return true;
    }
}

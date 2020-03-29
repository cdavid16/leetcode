package leetcode.algorithms;
class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;

        int i=0,j=0, indexOf = -1;

        while (i<haystack.length()){
            if((int)haystack.charAt(i)==(int)needle.charAt(j)){
                indexOf = indexOf==-1?i:indexOf;
                j++;
                if(j==needle.length())
                    return indexOf;
            }
            else{
                if(indexOf>=0){
                    i=indexOf;
                    j=0;
                    indexOf = -1;
                }

            }
            i++;

        }
        return -1;

    }
}

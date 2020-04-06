package leetcode.algorithms;

import java.util.HashMap;

class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put((int)'I', 1);
        map.put((int)'V', 5);
        map.put((int)'X', 10);
        map.put((int)'L', 50);
        map.put((int)'C', 100);
        map.put((int)'D', 500);
        map.put((int)'M', 1000);
        for(int i=0; i<s.length(); i++)
        {
            //System.out.println(s.charAt(i));

            if(map.get( (int) s.charAt(i))==null)
                return 0;

            if(i>0)
            {
                if(map.get((int)s.charAt(i-1)).hashCode() < map.get((int)s.charAt(i)).hashCode())
                {
                    result -= (2*map.get((int)s.charAt(i-1)).hashCode());
                }
            }
            result += map.get((int)s.charAt(i)).hashCode();
        }
        return result;
    }
}

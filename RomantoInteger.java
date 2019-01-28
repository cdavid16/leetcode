class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        HashMap map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i=0; i<s.length(); i++)
        {
            //System.out.println(s.charAt(i));

            if(map.get(s.charAt(i))==null)
                return 0;

            if(i>0)
            {
                if(map.get(s.charAt(i-1)).hashCode() < map.get(s.charAt(i)).hashCode())
                {
                    result -= (2*map.get(s.charAt(i-1)).hashCode());
                }
            }
            result += map.get(s.charAt(i)).hashCode();
        }
        return result;
    }
}

package leetcode.algorithms;
class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x<0? true : false;
        x = Math.abs(x);
        long y = 0;
        int power = 1, maxPower  = (int)Math.log10(x), modCurrent = -1;
        while(x>0)
        {
            modCurrent = (x%(int)Math.pow(10, power))/ (int)Math.pow(10, power-1);

            y+= (modCurrent * Math.pow(10, maxPower));
            if(y > Integer.MAX_VALUE)
                return 0;
            x-= (modCurrent * (int)Math.pow(10, power-1));
            power++;
            maxPower--;
        }

        y *= isNegative? -1 : 1;
        return (int)y;
    }
}

package leetcode.algorithms;
class AddBinary {
    public String addBinary(String a, String b) {
        //1=49, 0=48
        String sum = "";

        int i=a.length()-1, j=b.length()-1, carry =0;
        int bitA = 0, bitB = 0;
        while (i>=0 || j>=0){
            bitA = ((int)i>=0?a.charAt(i--):0)%48;
            bitB = ((int)j>=0?b.charAt(j--):0)%48;
            sum = Integer.toString(((bitA^bitB)^carry)) + sum;
            carry = (((bitA+bitB)+carry)&2)/2;
        }
        if(carry>0)
            sum = Integer.toString(carry)+sum;
        return sum;
    }
}

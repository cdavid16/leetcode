class PlusOne {
  public int[] plusOne(int[] digits) {
        int i=digits.length-1, carry = 1;
        do{
            digits[i]=digits[i]+carry;
            carry = (int)Math.floor(digits[i]/10);
            digits[i]=digits[i]%10;

            if(carry==0)
                return digits;
            i--;
        }while (i>=0);

        if(carry>0){
            int[] tmp = new int[digits.length+1];
            tmp[0] = carry;
            for(int x=0; x< digits.length;x++)
                tmp[x+1]=digits[x];


            return tmp;
        }

        return digits;
    }
}

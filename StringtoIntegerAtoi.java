class Solution {

    public int myAtoi(String str) {
        //ascii value for numbers: 48-57
        //Whitespace: 32
        //Negative symbol: 45
        //Sum symbol: 43
        if(str.length()==0)
            return 0;

        boolean isNegative = false;
        int strNum;
        String num = "";
        HashSet<Integer> exceptions = new HashSet<>();
        exceptions.add(32);
        exceptions.add(45);
        exceptions.add(43);

        for(int i =0; i<str.length();i++){
            int ascii =(int)str.charAt(i);
            if(ascii>=48 && ascii<=57){
                num += Character.toString(str.charAt(i));
            }
            else{
                if(exceptions.contains(ascii)){
                    if(num.length()==0){
                        if(ascii != 32){
                            exceptions.clear();
                            if(ascii==45)
                                isNegative=true;
                        }
                        else
                            continue;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(num.length()==0)
                        return 0;
                    break;
                }
            }

        }

        if(num.length()==0)
            return 0;

        try{
            strNum = new Integer(num);
            return strNum * (isNegative?-1:1);
        }
        catch (NumberFormatException ex){
            if(!isNegative)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
    }
    
}

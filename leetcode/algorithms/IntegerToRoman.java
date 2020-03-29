package leetcode.algorithms;

import java.util.Stack;

class IntegerToRoman {
    public String intToRoman(int num) {
        if(num<1 || num>3999)
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        Stack<Character> keys = createMap();
        int cont = 0, power = 3;
        char current = ' ';
        char fourCase = ' ';
        String roman="";
        while(keys.size()>0){
            int pow = (int)(Math.pow(10, power));
            int currentValueInt = pow * ((cont%2)==0?1:5);
            int mult = (int)(num/pow);
            //evaluate 4 case
            if((mult == 4 && (cont%2)==0) || mult ==9){
                fourCase = current;
                if(mult==9){
                    keys.pop();
                    cont++;
                }
            }

            current = keys.pop();


            if(fourCase == ' '){
                for(int times = 0 ; times < (int)(num/currentValueInt); times++){
                    roman += Character.toString(current);
                }
                num -= (int)(currentValueInt)*(num/currentValueInt);
            }
            else{
                roman += ( Character.toString(current) + Character.toString(fourCase));
                num -= mult*pow;
            }


            cont++;
            fourCase = ' ';

            power -= (cont%2);
        }


        return roman;
    }

    private Stack createMap(){
        Stack keys = new Stack<>();
        keys.add('I'); //1      //73
        keys.add('V'); //5      //86
        keys.add('X'); //10     //88
        keys.add('L'); //50     //76
        keys.add('C'); //100    //67
        keys.add('D'); //500    //68
        keys.add('M'); //1000   //77
        return keys;
    }
}

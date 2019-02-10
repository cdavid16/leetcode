import java.util.*;

public class test {

    public static void main(String[] args){
        Solution sol = new Solution();
        //int dividend=0b11111111111111111111111111111111,divisor=0b0000000000000000000000000000001;
        //int dividend=0b0000000000000000000000000000011,divisor=0b0000000000000000000000000001010;
        //System.out.println(dividend);
        //System.out.println(divisor);
        //System.out.println(dividend|divisor);
        //System.out.println(sol.divide(dividend, divisor));
        int[] nums = {1,2,3};
        sol.nextPermutation(nums);
    }

}

class Solution {

    public void nextPermutation(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums.length-1;i>=0; i-- ){
            map.put((int)Math.pow(10, i), nums[i]);
        }

        for(Map.Entry entry : map.entrySet()){
            System.out.println("Key="+ entry.getKey());
            System.out.println("Value="+entry.getValue());
        }

    }

    public String multiply(String num1, String num2) {

    }

}

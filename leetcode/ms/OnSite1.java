package leetcode.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        Arrays.sort(nums);
        int diff = 1;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=prev){
                nums[diff]=nums[i];
                diff++;
            }                
            
            prev = nums[i];
        }
        
        return diff;
    }
    
    //Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    public List<String> restoreIpAddresses(String s) {
        List<String> validIPs = new ArrayList<>();
        if(s.length()==0){
            return validIPs;
        }
        
        return validIPs;
    }
    
    //There are N children standing in a line. Each child is assigned a rating value.
    public int candy(int[] ratings) {
        if(ratings.length<=1){
            return 1;
        }
        int[] candies = new int[ratings.length];
        int qty=ratings.length;
        int i=1; 
        if(ratings[0]>ratings[1])
            candies[0]=1;
        for(;i<ratings.length-1;i++){
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
            if(ratings[i]>ratings[i+1])
                candies[i]=candies[i+1]+1;            
        }
        
        for(int c: candies)
            qty+=c;
        
        System.out.println(Arrays.toString(candies));
        
        return qty;
    }
}
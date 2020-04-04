package leetcode.algorithms;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  /*public int singleNumber(int[] nums) {

    if (nums.length == 1)
      return nums[0];

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : nums) {
      if (!map.containsKey(n))
        map.put(n, 0);

      map.put(n, map.get(n) + 1);
    }

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (e.getValue() == 1)
        return e.getKey();
    }
    return 0;
  }*/
  
  public int singleNumber(int[] nums) {
      int sum = nums[0];
      for(int i=1; i<nums.length;i++){
          if(i%2==1){
              sum-=nums[i];
          }else{
              sum+=nums[i];
          }
      }
      return sum;
  }



  
  
}

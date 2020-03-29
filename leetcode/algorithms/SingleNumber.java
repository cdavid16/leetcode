package leetcode.algorithms;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  public int singleNumber(int[] nums) {

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
  }

}

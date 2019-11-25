import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TopKFrequent {

  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> topFrecuent = new ArrayList<Integer>();
    HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    if (nums.length == 1) {
      topFrecuent.add(nums[0]);
      return topFrecuent;
    }

    for (int n : nums) {
      if (!elements.containsKey(n))
        elements.put(n, 0);
      elements.put(n, elements.get(n) + 1);
    }

    AtomicInteger i = new AtomicInteger(0);
    elements.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> {
          i.getAndAdd(1);
          if (i.get() <= k) {
            topFrecuent.add(x.getKey());
          }
        });



    return topFrecuent;
  }
}

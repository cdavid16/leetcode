import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class NumberWithEqualDigitSum {

    public int solution(int[] A) {
        if (A.length > 200000 || A.length < 2) { // check whether array length is greater than valid or less than two pairs
            return -1;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); // since it already implement sort functionality go ahead with this hash
        int sum = -1;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            List<Integer> array = new ArrayList<Integer>();
            int N = A[i];
            while (N > 10) {
                array.add(N / 10);
                N %= 10;
            }
            array.add(N);
            sum = array.stream().mapToInt(n -> n).sum();
            System.out.println(String.format("%d, sum of digits={%d}", A[i], sum));
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }


        Entry<Integer, List<Integer>> entry = null;
        sum = -1;
        for (Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (e.getValue().size() > 1) {
                entry = e;
                break;
            }
        }

        if (entry != null) {
            List<Integer> arr = entry.getValue();
            Integer prev = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                sum = Math.max(sum, A[prev] + A[arr.get(i)]);
                prev = arr.get(i);
            }
        }



        return sum;
    }

    public static int getSolution(int[] A) {
        NumberWithEqualDigitSum solution = new NumberWithEqualDigitSum();
        return solution.solution(A);
    }

}

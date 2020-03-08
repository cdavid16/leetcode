package coding.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cvillare
 *
 */
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> events = new LinkedList<>();;
        Arrays.sort(products); // sort lexicographically
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> state = new ArrayList<>();
            for (int j = 0; j < products.length && state.size() < 3; j++) {
                if (products[j].startsWith(searchWord.substring(0, i + 1))) {
                    state.add(products[j]);
                }
            }
            events.add(state);
        }
        System.out.println(events);
        return events;

    }

}

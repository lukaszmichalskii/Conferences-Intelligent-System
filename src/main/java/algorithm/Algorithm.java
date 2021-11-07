package main.java.algorithm;

import java.util.List;
import java.util.Map;

public interface Algorithm {
    Map<Integer, List<Integer>> provideSuggestions(Integer suggestionsNumber);
    static Integer calculateFit() {
        return 0;
    }
}

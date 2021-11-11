package main.java.algorithm;

import java.util.List;
import java.util.Map;

/**
 * Defines the method and the structure how we represent output to user
 */
public interface Algorithm {
    Map<Integer, List<Integer>> provideSuggestions(Integer suggestionsNumber);
}

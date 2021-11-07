package main.java.database;

import java.util.List;
import java.util.Map;

public class SuggestionsDataRepository {
    private final Map<Integer, List<Integer>> suggestionsData;

    public SuggestionsDataRepository(Map<Integer, List<Integer>> suggestionsData) {
        this.suggestionsData = suggestionsData;
    }

    public Map<Integer, List<Integer>> getSuggestionsData() {
        return suggestionsData;
    }
}

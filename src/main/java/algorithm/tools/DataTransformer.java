package main.java.algorithm.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTransformer {
    public Map<Integer, Map<Integer, List<Integer>>> transformDataToMoreReadableForm(Map<Integer, Map<Integer, Integer>> results, List<Integer> allMatchValues) {
        Map<Integer, Map<Integer, List<Integer>>> organizedResults = new HashMap<>();
        for (Integer ID: results.keySet()) {
            Map<Integer, List<Integer>> matchIDData = new HashMap<>();
            for (Integer i: allMatchValues) {
                List<Integer> IDs = new ArrayList<>();
                results.get(ID).forEach((k,val) -> {
                    if (val.equals(i)) {
                        if (k != null)
                            IDs.add(k);
                    }
                });
                if (IDs.size() > 0)
                    matchIDData.put(i, IDs);
            }
            organizedResults.put(ID, matchIDData);
        }

        return organizedResults;
    }

}

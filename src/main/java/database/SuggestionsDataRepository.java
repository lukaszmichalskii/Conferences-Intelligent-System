package main.java.database;

import java.util.List;
import java.util.Map;

/**
 * Class stores results of algorithm calculations (suggestions) for each participant in structure:
 * ID -> [ID_1st, ID_2nd, ... ID_Nth] where ID1st is the participant with the best match value parameter
 */
public class SuggestionsDataRepository {
    private final Map<Integer, List<Integer>> suggestionsData;

    public SuggestionsDataRepository(Map<Integer, List<Integer>> suggestionsData) {
        this.suggestionsData = suggestionsData;
    }

    public StringBuilder dataToString() {
        StringBuilder dataStringRepresentation = new StringBuilder();
        for (Integer ID: suggestionsData.keySet()) {
            String info = "ID: " + ID + ", suggestions: " + suggestionsData.get(ID) + "\n";
            dataStringRepresentation.append(info);
        }
        return dataStringRepresentation;
    }
}

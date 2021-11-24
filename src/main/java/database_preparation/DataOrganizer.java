package main.java.database_preparation;

import main.java.participant.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Class organize data to better reading and easier calculation of logic for the algorithm
 */
public class DataOrganizer {
    private final List<String> dataToOrganize;

    public DataOrganizer(List<String> dataToOrganize) {
        this.dataToOrganize = dataToOrganize;
    }

    public List<Participant> organizeData() {
        List<List<String>> raw_data = reformatData();
        List<Participant> data = new ArrayList<>();
        for (List<String> attribute: raw_data) {
            Integer ID = Integer.parseInt(attribute.get(0));
            List<String> occupation = extractOccupation(attribute);
            List<String> interestArea = extractInterestArea(attribute);
            List<String> attributes = mergeArrays(occupation, interestArea);
            attributes = removeDuplicates(attributes);

            // create useful data
            data.add(new Participant(ID, attributes, occupation, interestArea));
        }

        return data;
    }

    /**
     * Method transform data from raw to bit cleaner
     */
    private List<List<String>> reformatData() {
        List<List<String>> data = new ArrayList<>();
        for (String line: dataToOrganize) {
            data.add(Arrays.asList(line.split("\\s+")));
        }

        return data;
    }

    private List<String> extractOccupation(List<String> raw_data) {
        return new ArrayList<>(Arrays.asList(raw_data.get(1).split(",")));
    }

    private List<String> extractInterestArea(List<String> raw_data) {
        return new ArrayList<>(Arrays.asList(raw_data.get(2).split(",")));
    }

    public static List<String> removeDuplicates(List<String> array) {
        return new ArrayList<>(new HashSet<>(array));
    }

    public static List<String> mergeArrays(List<String> array1, List<String> array2) {
        List<String> mergedArray = new ArrayList<>();
        mergedArray.addAll(array1);
        mergedArray.addAll(array2);

        return mergedArray;
    }
}

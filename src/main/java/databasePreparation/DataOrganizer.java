package main.java.databasePreparation;

import main.java.participant.Participant;

import java.util.ArrayList;
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
        return null;
    }

    /**
     * Method transform data from raw to bit cleaner
     */
    private List<List<String>> reformatData() {
        return null;
    }

    private List<String> extractOccupation(List<String> raw_data) {
        return null;
    }

    private List<String> extractInterestArea(List<String> raw_data) {
        return null;
    }

    public static List<String> removeDuplicates(List<String> array) {
        return new ArrayList<>(new HashSet<>(array));
    }

    public static List<String> mergeArrays(List<String> array1, List<String> array2) {
        return null;
    }
}

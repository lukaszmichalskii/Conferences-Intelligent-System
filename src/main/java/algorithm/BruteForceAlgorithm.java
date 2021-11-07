package main.java.algorithm;

import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;
import main.java.participant.Participant;

import java.util.*;

/**
 * Brute force algorithm calculate all match value parameter for all participants
 * Return best matching suggestions ('suggestionsNumber' people) to every analyzed participant
 */
public class BruteForceAlgorithm implements Algorithm {
    private ParticipantsDataRepository participantsDataRepository;
    private DataTransformer dataTransformer;

    public BruteForceAlgorithm(ParticipantsDataRepository participantsDataRepository, DataTransformer dataTransformer) {
        this.participantsDataRepository = participantsDataRepository;
        this.dataTransformer = dataTransformer;
    }

    @Override
    public Map<Integer, List<Integer>> provideSuggestions(Integer suggestionsNumber) {
        Map<Integer, Map<Integer, Integer>> results = findMatchParameterForAll(participantsDataRepository.getData());
        List<Integer> allMatchValues = findAllPossibleMatchValue(results);
        Map<Integer, Map<Integer, List<Integer>>> org = dataTransformer.transformDataToMoreReadableForm(results, allMatchValues);

        return findParticipantsWithBestMatchValue(org, allMatchValues, suggestionsNumber);
    }

    private Map<Integer, Map<Integer, Integer>> findMatchParameterForAll(List<Participant> data) {
        Map<Integer, Map<Integer, Integer>> results = new HashMap<>();
        for (Participant analyzedPerson : data) {
            Map<Integer, Integer> matching = new HashMap<>();
            for (Participant participant : data) {
                int matchValue = 0;
                if (participant != analyzedPerson) {
                    for (String attribute : analyzedPerson.getInterestArea()) {
                        for (String attributeOfOther : participant.getInterestArea()) {
                            if (attribute.equals(attributeOfOther)) {
                                matchValue += 1;
                            }
                        }
                    }
                    matching.put(participant.getID(), matchValue);
                }
            }
            results.put(analyzedPerson.getID(), matching);
        }

        return results;
    }

    private List<Integer> findAllPossibleMatchValue(Map<Integer, Map<Integer, Integer>> results) {
        List<Integer> allMatchValues = new ArrayList<>();
        for (Integer ID : results.keySet()) {
            for (Integer keyID : results.get(ID).keySet()) {
                allMatchValues.add(results.get(ID).get(keyID));
            }
        }

        allMatchValues = new ArrayList<>(new HashSet<>(allMatchValues));

        return allMatchValues;
    }

    private Map<Integer, List<Integer>> findParticipantsWithBestMatchValue(Map<Integer, Map<Integer, List<Integer>>> org, List<Integer> allMatchValues, Integer numberOfSuggestions) {
        Collections.reverse(allMatchValues);

        Map<Integer, List<Integer>> filteredResults = new HashMap<>();

        for (Integer ID: org.keySet()) {
            int counter = 0;
            List<Integer> selectedParticipants = new ArrayList<>();

            for (Integer match: allMatchValues) {
                if (org.get(ID).containsKey(match))
                    for (Integer index: org.get(ID).get(match)) {
                        if (counter < numberOfSuggestions) {
                            selectedParticipants.add(index);
                            counter += 1;
                        }
                    }
            }
            filteredResults.put(ID, selectedParticipants);
        }
        return filteredResults;
    }
}

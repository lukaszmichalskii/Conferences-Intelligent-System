package main.java.algorithm;

import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;
import main.java.participant.Participant;

import java.util.List;
import java.util.Map;

public class BruteForceAlgorithm implements Algorithm {
    private ParticipantsDataRepository participantsDataRepository;
    private DataTransformer dataTransformer;

    public BruteForceAlgorithm(ParticipantsDataRepository participantsDataRepository, DataTransformer dataTransformer) {
        this.participantsDataRepository = participantsDataRepository;
        this.dataTransformer = dataTransformer;
    }

    @Override
    public Map<Integer, List<Integer>> provideSuggestions(Integer suggestionsNumber) {
        return null;
    }

    private Map<Integer, Map<Integer, Integer>> findMatchParameterForAll(List<Participant> data) {
        return null;
    }

    private List<Integer> findAllPossibleMatchValue(Map<Integer, Map<Integer, Integer>> results) {
        return null;
    }

    private Map<Integer, List<Integer>> findParticipantsWithBestMatchValue(Map<Integer, Map<Integer, List<Integer>>> org, List<Integer> allMatchValues, Integer numberOfSuggestions) {
        return null;
    }
}

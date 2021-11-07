package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.algorithm.BruteForceAlgorithm;
import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;

public class SystemInitializer {
    private ParticipantsDataRepository dataRepository;

    public SystemInitializer(ParticipantsDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Algorithm init() {

        // define algorithm strategy
        DataTransformer dataTransformer = new DataTransformer();
        if (dataRepository.getNumberOfParticipants() < 20) {
            return new BruteForceAlgorithm(dataRepository, dataTransformer);
        }

        return null;
    }
}

package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.algorithm.BruteForceAlgorithm;
import main.java.algorithm.genetic_algorithm.GeneticAlgorithm;
import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;

public class SystemInitializer {
    private final ParticipantsDataRepository dataRepository;
    private final int profitabilityIndex;
    private final int maxIterWithoutChangeFit;
    private final int maxPopulation;

    public SystemInitializer(ParticipantsDataRepository dataRepository, int profitabilityIndex, int maxIterWithoutChangeFit, int maxPopulation) {
        this.dataRepository = dataRepository;
        this.profitabilityIndex = profitabilityIndex;
        this.maxIterWithoutChangeFit = maxIterWithoutChangeFit;
        this.maxPopulation = maxPopulation;
    }

    public Algorithm init() {

        // define algorithm strategy
        DataTransformer dataTransformer = new DataTransformer();
        if (dataRepository.getNumberOfParticipants() <= profitabilityIndex) {
            return new BruteForceAlgorithm(dataRepository.getData(), dataTransformer);
        }
        else if (dataRepository.getNumberOfParticipants() > profitabilityIndex) {
            return new GeneticAlgorithm(dataRepository, maxIterWithoutChangeFit, maxPopulation);
        }


        return null;
    }
}

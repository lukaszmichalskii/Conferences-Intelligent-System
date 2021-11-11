package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.algorithm.BruteForceAlgorithm;
import main.java.algorithm.genetic_algorithm.GeneticAlgorithm;
import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;

/**
 * Class responsible for initialize the algorithm used by perform calculations and finding best fit
 */
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

    /**
     * Method initialize algorithm technique based on size of data and determine how results will be calculated.
     * Using brute force or genetic algorithm
     * @return core calculation engine used for find best fit
     */
    public Algorithm init() {
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

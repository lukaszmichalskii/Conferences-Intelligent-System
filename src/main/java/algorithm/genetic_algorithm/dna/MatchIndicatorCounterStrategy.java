package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.List;

/**
 * Interface created just in case a different calculation function is needed (polymorphism)
 */
public interface MatchIndicatorCounterStrategy {
    int calculateFitness(Participant[] genes, List<String> attributesTarget);
}

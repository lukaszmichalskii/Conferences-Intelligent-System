package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.List;

public interface MatchIndicatorCounterStrategy {
    int calculateFitness(Participant[] genes, List<String> attributesTarget);
}

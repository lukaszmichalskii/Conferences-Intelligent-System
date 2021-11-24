package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.List;

/**
 * Implementation of fitness function
 */
public class MatchIndicatorCounter implements MatchIndicatorCounterStrategy {
    public int calculateFitness(Participant[] genes, List<String> attributesTarget) {
        int score = 0;
        for (Participant p: genes) {
            for (String attribute: attributesTarget) {
                for (String interest: p.getAttributes()) {
                    if (attribute.equals(interest)) {
                        score += 1;
                    }
                }
            }
        }
        return score;
    }
}

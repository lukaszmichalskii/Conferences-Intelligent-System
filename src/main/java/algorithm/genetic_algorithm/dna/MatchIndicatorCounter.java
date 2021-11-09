package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.List;

public class MatchIndicatorCounter implements MatchIndicatorCounterStrategy {
    public int calculateFitness(Participant[] genes, List<String> attributesTarget) {
        int score = 0;
        for (Participant p: genes) {
            for (String attribute: attributesTarget) {
                for (String interest: p.getInterestArea()) {
                    if (attribute.equals(interest)) {
                        score += 1;
                    }
                }
            }
        }
        return score;
    }
}

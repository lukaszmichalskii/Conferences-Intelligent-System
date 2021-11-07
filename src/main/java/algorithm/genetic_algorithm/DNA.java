package main.java.algorithm.genetic_algorithm;

import main.java.participant.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DNA {
    private Participant[] genes;
    private int fitness = 0;

    public DNA(Integer DNAsize, List<Participant> participants) {
        List<Participant> copy = participants;
        this.genes = new Participant[DNAsize];
        for (int i = 0; i < DNAsize; i++) {
            int rnd = new Random().nextInt(copy.size());
            Participant participant = copy.get(rnd);
            copy.remove(rnd);
            this.genes[i] = participant;
        }
    }

    public void calculateFitness(List<String> attributesTarget) {
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

        this.fitness = score;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "DNA: " + Arrays.toString(genes);
    }

    public DNA crossover(DNA parentB, List<Participant> participants) {
        DNA child = new DNA(this.genes.length, participants);
        for (int i = 0; i < this.genes.length; i++) {
            int midpoint = new Random().nextInt(genes.length);
            if (i > midpoint) {
                child.genes[i] = this.genes[i];
            }
            else {
                child.genes[i] = parentB.genes[i];
            }
        }

        return child;
    }

//    public void mutate(float mutationRate) {
//        for (int i = 0; i < this.genes.length; i++) {
//            if (Math.random() < mutationRate) {
//                this.genes[i] =
//            }
//        }
//    }
}

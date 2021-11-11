package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class defines the crossover idea of inheritance
 */
public class GeneticInheritanceProcess implements GeneticInheritanceProcessStrategy {
    private List<Participant> participants;

    public GeneticInheritanceProcess(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public DNA crossover(DNA parentA, DNA parentB) {
        DNA child = new DNA(parentA.getGenes().length, participants, Boolean.TRUE);
        for (int i = 0; i < parentA.getGenes().length; i++) {
            int splitPoint = new Random().nextInt(parentA.getGenes().length);
            if (splitPoint < i && !Arrays.asList(child.getGenes()).contains(parentA.getGenes()[i])) {
                child.setGene(i, parentA.getGenes()[i]);
            }
            else if (splitPoint >= i && !Arrays.asList(child.getGenes()).contains(parentB.getGenes()[i])) {
                child.setGene(i, parentB.getGenes()[i]);
            }
            else {
                int idx = new Random().nextInt(this.participants.size());
                Participant gene = this.participants.get(idx);
                while (Arrays.asList(child.getGenes()).contains(gene)) {
                    idx = new Random().nextInt(this.participants.size());
                    gene = this.participants.get(idx);
                }
                child.setGene(i, gene);
            }
        }
        return child;
    }
}

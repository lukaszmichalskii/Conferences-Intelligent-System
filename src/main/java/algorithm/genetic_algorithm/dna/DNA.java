package main.java.algorithm.genetic_algorithm.dna;

import main.java.participant.Participant;

import java.util.*;

/**
 * Class simulate the DNA in the genetic algorithm where the core is participants
 */
public class DNA {
    private Participant[] genes;
    private MatchIndicatorCounter matchIndicatorCounter;
    private GeneticInheritanceProcess geneticInheritanceProcess;
    private int fitness = 0;

    public DNA(Integer suggestionsNr, List<Participant> listToPickParticipant, Boolean isDummy) {
        List<Participant> participants = new ArrayList<>(listToPickParticipant);
        this.genes = new Participant[suggestionsNr];
        this.matchIndicatorCounter = new MatchIndicatorCounter();
        this.geneticInheritanceProcess = new GeneticInheritanceProcess(participants);
        if (isDummy) {
            for (int i = 0; i < suggestionsNr; i++) {
                Participant watchman = new Participant(-1, List.of("WATCHMAN"), List.of("DUMMY_JOB"), List.of("DUMMY_INTEREST"));
                this.genes[i] = watchman;
            }
        }
        else {
            for (int i = 0; i < suggestionsNr; i++) {
                int rnd = new Random().nextInt(listToPickParticipant.size());
                Participant participant = listToPickParticipant.get(rnd);
                this.genes[i] = participant;
                listToPickParticipant.remove(rnd);
            }
        }
    }

    public DNA crossover(DNA parentB) {
        return geneticInheritanceProcess.crossover(this, parentB);
    }

    public void calculateFitness(List<String> attributesTarget) {
        this.fitness = matchIndicatorCounter.calculateFitness(this.genes, attributesTarget);
    }

    public int getFitness() {
        return fitness;
    }

    public Participant[] getGenes() {
        Participant[] copy = new Participant[genes.length];
        System.arraycopy(genes, 0, copy, 0, genes.length);
        return copy;
    }

    public void setGene(int position, Participant gene) {
        this.genes[position] = gene;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Score = ").append(fitness).append("\nGenes: \n");
        for (Participant gene : genes) {
            info.append(gene.toString()).append("\n");
        }
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DNA)) return false;
        DNA dna = (DNA) o;
        return fitness == dna.fitness && Arrays.equals(genes, dna.genes) && Objects.equals(matchIndicatorCounter, dna.matchIndicatorCounter) && Objects.equals(geneticInheritanceProcess, dna.geneticInheritanceProcess);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(matchIndicatorCounter, geneticInheritanceProcess, fitness);
        result = 31 * result + Arrays.hashCode(genes);
        return result;
    }
}

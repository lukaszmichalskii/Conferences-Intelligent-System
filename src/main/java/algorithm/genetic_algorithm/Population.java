package main.java.algorithm.genetic_algorithm;

import main.java.algorithm.genetic_algorithm.dna.DNA;
import main.java.participant.Participant;
import main.java.system.output.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
    private final DNA[] population;
    private final List<DNA> matingPool = new ArrayList<>();
    private DNA curr_best;

    public Population(Integer popMax, Integer suggestionsNumber, List<Participant> dataWithoutTarget, Participant target) {
        population = new DNA[popMax];
        curr_best = new DNA(suggestionsNumber, dataWithoutTarget, Boolean.TRUE);
        curr_best.calculateFitness(target.getInterestArea());
        for (int i = 0; i < popMax; i++) {
            population[i] = new DNA(suggestionsNumber, new ArrayList<>(dataWithoutTarget), Boolean.FALSE);
        }
    }

    public void naturalSelection() {
        for (DNA dna : this.population) {
            for (int j = 0; j < dna.getFitness(); j++) {
                this.matingPool.add(dna);
            }
        }
    }

    public void generate() {
        for (int i = 0; i < this.population.length; i++) {
            int A = new Random().nextInt(matingPool.size());
            int B = new Random().nextInt(matingPool.size());
            while (A == B) {
                B = new Random().nextInt(matingPool.size());
            }
            DNA parentA = this.matingPool.get(A);
            DNA parentB = this.matingPool.get(B);
            DNA child = parentA.crossover(parentB);
            population[i] = child;
        }
    }

    public void calcFitness(Participant target) {
        for (DNA dna : population) {
            dna.calculateFitness(target.getInterestArea());
            System.out.println("Current best: " + curr_best.toString() + "Analyzed selection: " + dna);

            if (curr_best.getFitness() < dna.getFitness()) {
                System.out.println("____________________________________________________________________________________________");
                System.out.println(Colors.ANSI_YELLOW + "Update best: " + curr_best + " to: " + dna + Colors.ANSI_RESET);
                System.out.println("____________________________________________________________________________________________");

                curr_best = dna;
            }
        }
    }

    public DNA getCurr_best() {
        return curr_best;
    }
}

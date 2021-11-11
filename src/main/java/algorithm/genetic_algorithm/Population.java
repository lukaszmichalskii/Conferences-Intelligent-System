package main.java.algorithm.genetic_algorithm;

import main.java.algorithm.genetic_algorithm.dna.DNA;
import main.java.participant.Participant;
import main.java.system.output.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class represents population (combinations of participants)
 */
public class Population {
    /**
     * Combinations of possibly best fit objects
     */
    private final DNA[] population;
    /**
     * Data structure that stores data about combinations of fit.
     * To simulate the real world probability if suggestion has fitness value = 4, there will be 4 such objects inside.
     * If we want to pick one element from matingPool we could get element with appropriate probability.
     */
    private final List<DNA> matingPool = new ArrayList<>();
    /**
     * current best fit object
     */
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

    /**
     * Method generate new generation based on probability defined by matingPool object
     */
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

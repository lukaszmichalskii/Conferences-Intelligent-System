package main.java.algorithm.genetic_algorithm;

import main.java.database.ParticipantsDataRepository;
import main.java.participant.Participant;

import java.util.*;

public class Population {
    private DNA[] population;
    private Map<DNA, Integer> fitness = new HashMap<>();
    private List<DNA> mating = new ArrayList<>();
    private float mutationRate;
    private List<Participant> participants;

    public Population(Integer popMax, Integer suggestionsNumber, ParticipantsDataRepository dataRepository, double mutationRate) {
        population = new DNA[popMax];
        this.participants = dataRepository.getData();
        for (int i = 0; i < popMax; i++) {
            population[i] = new DNA(suggestionsNumber, dataRepository.getData());
        }
    }

    public DNA findMax() {
        int max = -1;
        for (DNA dna: fitness.keySet()) {
            if (max < fitness.get(dna)) {
                max = fitness.get(dna);
            }
        }

        return getKey(fitness, max);
    }

    public <DNA, Integer> DNA getKey(Map<DNA, Integer> map, Integer value) {
        for (Map.Entry<DNA, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void calcFitness(List<String> target) {
        for (int i = 0; i < this.population.length; i++) {
//            System.out.println(target.toString());
            population[i].calculateFitness(target);
//            System.out.println("Score = "+population[i].getFitness()+", "+population[i]);
            fitness.put(population[i], population[i].getFitness());
        }
    }

    public void naturalSelection() {
        for (int i = 0; i < this.population.length; i++) {
            for (int j = 0; j < this.population[i].getFitness(); j++) {
                this.mating.add(this.population[i]);
            }
        }
    }

    public void generate() {
        for (int i = 0; i < this.population.length; i++) {
            int A = new Random().nextInt(mating.size());
//            System.out.println("A: " + A);
            int B = new Random().nextInt(mating.size());
//            System.out.println("B: " + B);

            while (A == B) {
                B = new Random().nextInt(mating.size());
//                System.out.println("B: " + B);
            }
            DNA parentA = this.mating.get(A);
//            System.out.println("ParentA: " + parentA.toString());

            DNA parentB = this.mating.get(B);
//            System.out.println("ParentB: " + parentB.toString());
            DNA child = parentA.crossover(parentB, new ArrayList<>(participants));
//            System.out.println("child: " + child.toString());
//            child.mutate(this.mutationRate);
            population[i] = child;
        }
    }

    public void print() {
        for (int i = 0; i < mating.size(); i++) {
            System.out.println(i + " -> " + mating.get(i));
        }
    }
}

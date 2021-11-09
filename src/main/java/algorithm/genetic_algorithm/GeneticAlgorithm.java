package main.java.algorithm.genetic_algorithm;

import main.java.algorithm.Algorithm;
import main.java.algorithm.genetic_algorithm.dna.DNA;
import main.java.database.ParticipantsDataRepository;
import main.java.participant.Participant;
import main.java.system.output.Colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneticAlgorithm implements Algorithm {
    private final ParticipantsDataRepository participantsDataRepository;
    private final int maxNumberOfIterationsWithoutChangingFit;
    private final int maxPopulationSize;

    public GeneticAlgorithm(ParticipantsDataRepository participantsDataRepository, int maxIt, int maxPopulationSize) {
        this.participantsDataRepository = participantsDataRepository;
        this.maxNumberOfIterationsWithoutChangingFit = maxIt;
        this.maxPopulationSize = maxPopulationSize;
    }

    @Override
    public Map<Integer, List<Integer>> provideSuggestions(Integer suggestionsNumber) {
        Map<Integer, List<Integer>> filteredResults = new HashMap<>();

        for (int i = 0; i < participantsDataRepository.getNumberOfParticipants(); i++) {
            Participant target = participantsDataRepository.getData().get(i);
            List<Participant> listOfParticipant = participantsDataRepository.getData();
            listOfParticipant.remove(target);
            Population population = new Population(maxPopulationSize , suggestionsNumber, new ArrayList<>(listOfParticipant), target);
            System.out.println(target);
            int best_score_it = 0;
            DNA curr_best = population.getCurr_best();
            while (best_score_it < maxNumberOfIterationsWithoutChangingFit) {
                population.calcFitness(target);
                if (curr_best.equals(population.getCurr_best())) {
                    best_score_it += 1;
                }
                else {
                    best_score_it = 0;
                    System.out.println(Colors.ANSI_GREEN + "New best fit: " + population.getCurr_best().toString() + Colors.ANSI_RESET);
                    curr_best = population.getCurr_best();
                }
                population.naturalSelection();
                population.generate();
            }
            System.out.println("_____________________________________________________________________");
            List<Integer> IDs = new ArrayList<>();
            for (int id = 0; id < population.getCurr_best().getGenes().length; id++) {
                IDs.add(population.getCurr_best().getGenes()[id].getID());
            }
            filteredResults.put(target.getID(), IDs);

        }

        return filteredResults;
    }

    @Override
    public String toString() {
        return "GAT (genetic algorithm technique)";
    }
}

package main.java;

import main.java.algorithm.genetic_algorithm.Population;
import main.java.database.ParticipantsDataRepository;
import main.java.databasePreparation.DataOrganizer;
import main.java.inputHandling.FileParseStrategy;
import main.java.inputHandling.InputParser;
import main.java.inputHandling.TxtFileParser;
import main.java.system.ConferenceIntelligentSystem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ConferenceIntelligentSystem system = new ConferenceIntelligentSystem(args[0], Integer.parseInt(args[1]));
//        system.runSystem();
        // get filepath
        Path filepath = Paths.get(args[0]);

        // parse data from filepath
        FileParseStrategy fileParser = new TxtFileParser();
        InputParser inputParser = new InputParser(fileParser);
        List<String> fileContent = inputParser.parseFile(filepath);

        // organize data
        DataOrganizer dataOrganizer = new DataOrganizer(fileContent);
        ParticipantsDataRepository participantsDataRepository = new ParticipantsDataRepository(dataOrganizer.organizeData());
        Population population = new Population(20, Integer.parseInt(args[1]), participantsDataRepository, 0.01);
        int maxIterations = 100;
        int iternations = 0;
        while (iternations < maxIterations) {
            population.calcFitness(participantsDataRepository.getData().get(3).getInterestArea());
            population.naturalSelection();
            population.generate();
            iternations += 1;
        }
        System.out.println("ID: " + participantsDataRepository.getData().get(3).getID() + "\nFit: " + population.findMax().toString());
    }


}

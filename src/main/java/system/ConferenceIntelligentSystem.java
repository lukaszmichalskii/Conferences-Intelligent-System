package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.algorithm.BruteForceAlgorithm;
import main.java.algorithm.tools.DataTransformer;
import main.java.database.ParticipantsDataRepository;
import main.java.database.SuggestionsDataRepository;
import main.java.databasePreparation.DataOrganizer;
import main.java.inputHandling.FileParseStrategy;
import main.java.inputHandling.InputParser;
import main.java.inputHandling.TxtFileParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ConferenceIntelligentSystem extends SystemAbstraction {
    private String filepathToSurveyData;
    private Integer suggestionsNumber;

    public ConferenceIntelligentSystem(String filepathToSurveyData, Integer suggestionsNumber) {
        this.filepathToSurveyData = filepathToSurveyData;
        this.suggestionsNumber = suggestionsNumber;
    }

    @Override
    public void runSystem() {
        // get filepath
        Path filepath = Paths.get(filepathToSurveyData);

        // parse data from filepath
        FileParseStrategy fileParser = new TxtFileParser();
        InputParser inputParser = new InputParser(fileParser);
        List<String> fileContent = inputParser.parseFile(filepath);

        // organize data
        DataOrganizer dataOrganizer = new DataOrganizer(fileContent);
        ParticipantsDataRepository participantsDataRepository = new ParticipantsDataRepository(dataOrganizer.organizeData());

        // define algorithm strategy
        DataTransformer dataTransformer = new DataTransformer();
        Algorithm algorithm = new BruteForceAlgorithm(participantsDataRepository, dataTransformer);

        // results of calculations
        Map<Integer, List<Integer>> suggestions = algorithm.provideSuggestions(suggestionsNumber);

        // store results into database
        SuggestionsDataRepository suggestionsDataRepository = new SuggestionsDataRepository(suggestions);

        // print results
        Printer resultsPrinter = new Printer();
        resultsPrinter.print(suggestionsDataRepository.dataToString().toString());
    }
}

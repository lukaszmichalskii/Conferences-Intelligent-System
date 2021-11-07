package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.database.ParticipantsDataRepository;
import main.java.database.SuggestionsDataRepository;
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
        ConferenceConfigurator conferenceConfigurator = new ConferenceConfigurator(filepathToSurveyData);
        ParticipantsDataRepository database = conferenceConfigurator.configure();
        SystemInitializer systemInitializer = new SystemInitializer(database);
        Algorithm calculationsEngine = systemInitializer.init();

        System.out.println(database.dataToString());

        // results of calculations
        Map<Integer, List<Integer>> suggestions = calculationsEngine.provideSuggestions(suggestionsNumber);

        // store results into database
        SuggestionsDataRepository suggestionsDataRepository = new SuggestionsDataRepository(suggestions);

        // print results
        Printer resultsPrinter = new Printer();
        resultsPrinter.print(suggestionsDataRepository.dataToString());
    }
}

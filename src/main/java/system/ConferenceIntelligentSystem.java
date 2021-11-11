package main.java.system;

import main.java.algorithm.Algorithm;
import main.java.database.ParticipantsDataRepository;
import main.java.database.SuggestionsDataRepository;
import main.java.system.output.Printer;

import java.util.List;
import java.util.Map;

/**
 * Core class of application, responsible for run calculations
 */
public class ConferenceIntelligentSystem extends SystemAbstraction {
    private final String filepathToSurveyData;
    private final Printer printer;
    private final Settings settings;

    public ConferenceIntelligentSystem(String filepathToSurveyData, Settings settings) {
        this.filepathToSurveyData = filepathToSurveyData;
        this.printer = new Printer();
        this.settings = settings;
    }

    @Override
    public void runSystem() {
        ConferenceConfigurator conferenceConfigurator = new ConferenceConfigurator(filepathToSurveyData);
        ParticipantsDataRepository database = conferenceConfigurator.configure();
        SystemInitializer systemInitializer = new SystemInitializer(database, settings.getPROFITABILITY_INDEX(), settings.getMAX_ITERATIONS_WITHOUT_CHANG_FIT(), settings.getMAX_POPULATION());
        Algorithm calculationsEngine = systemInitializer.init();

        printer.print(database.dataToString());

        // results of calculations
        Map<Integer, List<Integer>> suggestions = calculationsEngine.provideSuggestions(settings.getSUGGESTIONS_NUMBER());

        // store results into database
        SuggestionsDataRepository suggestionsDataRepository = new SuggestionsDataRepository(suggestions);

        // print results
        printer.print("Calculation preformed using " + calculationsEngine + ".");
        printer.print(suggestionsDataRepository.dataToString());
    }
}

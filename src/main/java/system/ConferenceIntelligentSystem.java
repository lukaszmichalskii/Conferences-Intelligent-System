package main.java.system;

import main.java.database.ParticipantsDataRepository;
import main.java.databasePreparation.DataOrganizer;
import main.java.inputHandling.FileParseStrategy;
import main.java.inputHandling.InputParser;
import main.java.inputHandling.TxtFileParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConferenceIntelligentSystem extends System {
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
    }
}

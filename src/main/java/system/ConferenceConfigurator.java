package main.java.system;

import main.java.database.ParticipantsDataRepository;
import main.java.database_preparation.DataOrganizer;
import main.java.inputHandling.FileParseStrategy;
import main.java.inputHandling.InputParser;
import main.java.inputHandling.TxtFileParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConferenceConfigurator {
    private final String filepathToSurveyData;

    public ConferenceConfigurator(String filepathToSurveyData) {
        this.filepathToSurveyData = filepathToSurveyData;
    }

    public ParticipantsDataRepository configure() {
        // get filepath
        Path filepath = Paths.get(filepathToSurveyData);

        // parse data from filepath
        FileParseStrategy fileParser = new TxtFileParser();
        InputParser inputParser = new InputParser(fileParser);
        List<String> fileContent = inputParser.parseFile(filepath);

        // organize data
        DataOrganizer dataOrganizer = new DataOrganizer(fileContent);

        return new ParticipantsDataRepository(dataOrganizer.organizeData());
    }
}

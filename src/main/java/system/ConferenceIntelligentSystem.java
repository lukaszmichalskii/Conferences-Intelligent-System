package main.java.system;

public class ConferenceIntelligentSystem extends System {
    private String filepathToSurveyData;
    private Integer suggestionsNumber;

    public ConferenceIntelligentSystem(String filepathToSurveyData, Integer suggestionsNumber) {
        this.filepathToSurveyData = filepathToSurveyData;
        this.suggestionsNumber = suggestionsNumber;
    }

    @Override
    public void runSystem() {
    }
}

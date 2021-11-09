package main.java;

import main.java.system.ConferenceIntelligentSystem;
import main.java.system.Settings;

public class Main {
    public static void main(String[] args) {
        String filepath = args[0];
        int profitabilityIndex = 5;
        int maxPopulation = 20;
        int maxIterWithoutChangeFit = 10;
        int suggestionsNumber = Integer.parseInt(args[1]);
        ConferenceIntelligentSystem system = new ConferenceIntelligentSystem(filepath,
                                             new Settings(suggestionsNumber, profitabilityIndex, maxPopulation, maxIterWithoutChangeFit));

        system.runSystem();
    }


}

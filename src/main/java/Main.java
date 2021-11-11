package main.java;

import main.java.system.ConferenceIntelligentSystem;
import main.java.system.Settings;

public class Main {
    public static void main(String[] args) {
        /**
         *  absolute path! to file with conferences participant data
         */
        String filepath = args[0];
        /**
         *   profitabilityIndex determine from what size of data
         *   it is more optimal to use genetic algorithm than brute force
         */
        int profitabilityIndex = 5;
        /**
         * max size of population to generate by genetic algorithm
         */
        int maxPopulation = 20;
        /**
         * maxIterWithoutChangeFit specifies the number of iterations unchanged currently the best fit.
         * The larger the number, the greater the probability of finding the best match (sufficient for relatively small datasets)
         */
        int maxIterWithoutChangeFit = 15;
        /**
         * number of suggestions we need for every conference participant
         */
        int suggestionsNumber = Integer.parseInt(args[1]);
        ConferenceIntelligentSystem system = new ConferenceIntelligentSystem(filepath,
                                             new Settings(suggestionsNumber, profitabilityIndex, maxPopulation, maxIterWithoutChangeFit));

        system.runSystem();
    }


}

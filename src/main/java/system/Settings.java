package main.java.system;

public class Settings {
    private final int SUGGESTIONS_NUMBER;
    private final int MAX_POPULATION;
    private final int MAX_ITERATIONS_WITHOUT_CHANG_FIT;
    private final int PROFITABILITY_INDEX;

    public Settings(int suggestionsNumber, int profitabilityIndex, int maxPopulation, int maxIterWithoutChangeFit) {
        this.SUGGESTIONS_NUMBER = suggestionsNumber;
        this.PROFITABILITY_INDEX = profitabilityIndex;
        this.MAX_POPULATION = maxPopulation;
        this.MAX_ITERATIONS_WITHOUT_CHANG_FIT = maxIterWithoutChangeFit;
    }

    public int getPROFITABILITY_INDEX() {
        return PROFITABILITY_INDEX;
    }

    public int getMAX_ITERATIONS_WITHOUT_CHANG_FIT() {
        return MAX_ITERATIONS_WITHOUT_CHANG_FIT;
    }

    public int getMAX_POPULATION() {
        return MAX_POPULATION;
    }

    public int getSUGGESTIONS_NUMBER() {
        return SUGGESTIONS_NUMBER;
    }
}

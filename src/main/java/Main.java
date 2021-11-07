package main.java;

import main.java.system.ConferenceIntelligentSystem;

public class Main {
    public static void main(String[] args) {
        ConferenceIntelligentSystem system = new ConferenceIntelligentSystem(args[0], Integer.parseInt(args[1]));
        system.runSystem();
    }
}

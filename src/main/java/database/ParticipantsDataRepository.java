package main.java.database;

import main.java.participant.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Class stores optional data entered by participants to calculate suggestions
 */
public class ParticipantsDataRepository implements Database {
    private final List<Participant> data;

    public ParticipantsDataRepository(List<Participant> data) {
        this.data = data;
    }

    public List<Participant> getData() {
        return new ArrayList<>(data);
    }

    public Integer getNumberOfParticipants() {
        return data.size();
    }

    public String dataToString() {
        StringBuilder dataStringRepresentation = new StringBuilder();
        for (Participant p: data) {
            String info = "ID: " + p.getID() + ", interest: " + p.getInterestArea() + "\n";
            dataStringRepresentation.append(info);
        }
        return dataStringRepresentation.toString();
    }
}

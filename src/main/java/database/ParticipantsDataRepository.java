package main.java.database;

import main.java.participant.Participant;

import java.util.List;

/**
 * Class stores optional data entered by participants to calculate suggestions
 */
public class ParticipantsDataRepository {
    private final List<Participant> data;

    public ParticipantsDataRepository(List<Participant> data) {
        this.data = data;
    }

    public List<Participant> getData() {
        return data;
    }

    public Integer getNumberOfParticipants() {
        return data.size();
    }
}

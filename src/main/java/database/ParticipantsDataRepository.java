package main.java.database;

import main.java.participant.Participant;

import java.util.List;

public class ParticipantsDataRepository {
    private final List<Participant> data;

    public ParticipantsDataRepository(List<Participant> data) {
        this.data = data;
    }

    public List<Participant> getData() {
        return data;
    }
}

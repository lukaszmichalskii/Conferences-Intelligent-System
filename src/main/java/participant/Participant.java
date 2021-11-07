package main.java.participant;

import java.util.List;

public class Participant {
    private final Integer ID;
    private final List<String> attributes;

    public Participant(Integer ID, List<String> attributes) {
        this.ID = ID;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "ID: " + ID.toString() + ", Attributes: " + attributes.toString();
    }

    public Integer getID() {
        return ID;
    }

    public List<String> getInterestArea() {
        return attributes; }
}

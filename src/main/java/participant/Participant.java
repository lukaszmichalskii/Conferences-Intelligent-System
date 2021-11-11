package main.java.participant;

import java.util.List;

/**
 * Class represent the object of participant every with ID and interest area
 */
public class Participant {
    /**
     * Identifier of each participant
     */
    private final Integer ID;
    /**
     * Compressed attributes: occupation + area of interest
     */
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

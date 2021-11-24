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
    private final List<String> occupation;
    private final List<String> interestArea;

    public Participant(Integer ID, List<String> attributes, List<String> occupation, List<String> interestArea) {
        this.ID = ID;
        this.attributes = attributes;
        this.occupation = occupation;
        this.interestArea = interestArea;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<String> getOccupation() {
        return occupation;
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

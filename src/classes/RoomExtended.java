package classes;

public class RoomExtended {
    private int numberOfGuests;
    private PersonExtended personExtended;

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public PersonExtended getPersonExtended() {
        return personExtended;
    }

    public void setPersonExtended(PersonExtended personExtended) {
        this.personExtended = personExtended;
    }

    public RoomExtended(int numberOfGuests, PersonExtended personExtended) {
        this.numberOfGuests = numberOfGuests;
        this.personExtended = personExtended;
    }
}


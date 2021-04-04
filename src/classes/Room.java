package classes;

public class Room {
    private int numberOfGuests;
    private Person person;

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Person getPersonExtended() {
        return person;
    }

    public void setPersonExtended(Person person) {
        this.person = person;
    }

    public Room(int numberOfGuests, Person person) {
        this.numberOfGuests = numberOfGuests;
        this.person = person;
    }
}


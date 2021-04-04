package classes;

public class Room {
    private int numberOfGuests;
    private Person person;

    public Room(int numberOfGuests, Person person) {
        this.numberOfGuests = numberOfGuests;
        this.person = person;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


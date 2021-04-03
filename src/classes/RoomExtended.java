package classes;

public class RoomExtended {
    String roomName;
    PersonExtended personExtended = new PersonExtended("e", "e", 0);

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public PersonExtended getPersonExtended() {
        return personExtended;
    }

    public void setPersonExtended(PersonExtended personExtended) {
        this.personExtended = personExtended;
    }

    public RoomExtended(String roomName, PersonExtended personExtended) {
        this.roomName = roomName;
        this.personExtended = personExtended;
    }
}


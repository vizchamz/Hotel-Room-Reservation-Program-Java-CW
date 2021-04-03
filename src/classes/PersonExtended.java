package classes;

public class PersonExtended {
    private String firstName;
    private String surName;
    private long cardNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public PersonExtended(String firstName, String surName, long cardNo) {
        this.firstName = firstName;
        this.surName = surName;
        this.cardNo = cardNo;
    }
}

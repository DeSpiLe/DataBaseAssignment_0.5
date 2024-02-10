package org.example.models;

public class Table {
    private short id, capacity;
    private boolean reserved;
    private String firstName,secondName,phoneNumber;
    public Table() {
    }

    public Table(String firstName,String secondName, short capacity, boolean reserved,String phoneNumber) {
        setFirstName(firstName);
        setSecondName(secondName);
        setCapacity(capacity);
        setReserved(reserved);
        setPhoneNumber(phoneNumber);
    }

    public Table(short id,String firstName,String secondName, short capacity, boolean reserved,String phoneNumber) {
        this(firstName,secondName,capacity,reserved,phoneNumber);
        setId(id);
    }




    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", reserved=" + reserved +
                ", personsFirstName='" + firstName + '\'' +
                ", personsSecondName='" + secondName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setFirstName(String personsFirstName) {
        this.firstName = personsFirstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String personsSecondName) {
        this.secondName = personsSecondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

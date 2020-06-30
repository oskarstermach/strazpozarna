package pl.ostermach.models;

public class Firefighter {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private long sectionId;

    public long getId() {
        return id;
    }

    public Firefighter setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Firefighter setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Firefighter setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public int getAge() {
        return age;
    }

    public Firefighter setAge(int age) {
        this.age = age;
        return this;
    }
}

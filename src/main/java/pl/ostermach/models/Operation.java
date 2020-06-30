package pl.ostermach.models;

public class Operation {
    private long id;
    private String name;
    private String date;
    private String location;

    public long getId() {
        return id;
    }

    public Operation setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Operation setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Operation setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Operation setDate(String date) {
        this.date = date;
        return this;
    }
}

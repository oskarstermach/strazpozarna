package pl.ostermach.models;

public class Car {
    private long id;
    private String plate;
    private String name;

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }

    public String getPlate() {
        return plate;
    }

    public Car setPlate(String plate) {
        this.plate = plate;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

}

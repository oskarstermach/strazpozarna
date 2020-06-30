package pl.ostermach;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import pl.ostermach.models.Car;
import pl.ostermach.models.Firefighter;
import pl.ostermach.models.Operation;


public class FirefighterUtils {

    private final GraphDatabaseService graphDatabaseService;

    public FirefighterUtils(GraphDatabaseService graphDatabaseService) {
        this.graphDatabaseService = graphDatabaseService;
    }

    public void saveFirefighterDate(Firefighter firefighter) {
        graphDatabaseService.beginTx();

        Node firefighterNode = graphDatabaseService.createNode(Label.label("Firefighter"));
        firefighterNode.setProperty("id", firefighter.getId());
        firefighterNode.setProperty("firstName", firefighter.getFirstName());
        firefighterNode.setProperty("lastName", firefighter.getLastName());
        firefighterNode.setProperty("age", firefighter.getAge());
    }

    public void saveCarDate(Car car) {
        graphDatabaseService.beginTx();

        Node carNode = graphDatabaseService.createNode(Label.label("Car"));
        carNode.setProperty("id", car.getId());
        carNode.setProperty("plate", car.getPlate());
        carNode.setProperty("name", car.getName());
    }

    public void saveOperationDate(Operation operation){
        graphDatabaseService.beginTx();

        Node operationNode = graphDatabaseService.createNode(Label.label("Operation"));
        operationNode.setProperty("id", operation.getId());
        operationNode.setProperty("date", operation.getDate());
        operationNode.setProperty("name", operation.getName());
        operationNode.setProperty("location", operation.getLocation());
    }

    public void deleteFirefighter(String id) {
        graphDatabaseService.beginTx();
        graphDatabaseService.execute("MATCH (firefighter:Firefighter)" +
                " WHERE firefighter.id=" + id+
                " DELETE firefighter");
    }

    public void deleteCar(String id) {
        graphDatabaseService.beginTx();
        graphDatabaseService.execute("MATCH (car:Car)" +
                " WHERE car.id=" + id +
                " DELETE car");
    }

    public void deleteOperation(String id) {
        graphDatabaseService.beginTx();
        graphDatabaseService.execute("MATCH (operation:Operation)" +
                " WHERE operation.id=" + id +
                " DELETE operation");
    }

    public Result updateFirefighter(int oldId, Firefighter firefighter) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute("MATCH (firefighter:Firefighter)" +
                "WHERE firefighter.id=" + oldId +
                " SET firefighter.firstName='" + firefighter.getFirstName() + "'" +
                " SET firefighter.lastName='" + firefighter.getLastName() + "'" +
                " SET firefighter.age='" + firefighter.getAge() + "'" +
                " RETURN firefighter");
    }

    public Result updateCar(int oldId, Car car) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute("MATCH (car:Car)" +
                "WHERE car.id=" + oldId +
                " SET car.plate='" + car.getPlate() + "'" +
                " SET car.name='" + car.getName() + "'" +
                " RETURN car");
    }

    public Result updateOperation(int oldId, Operation operation) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute("MATCH (operation:Operation)" +
                "WHERE operation.id=" + oldId +
                " SET operation.plate='" + operation.getDate() + "'" +
                " SET operation.name='" + operation.getName() + "'" +
                " SET operation.location='" + operation.getLocation() + "'" +
                " RETURN operation");
    }

    public Result listFirefighters() {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (f:Firefighter) RETURN f AS FireFighters");
    }

    public Result listCars() {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (c:Car) RETURN c AS Cars");
    }

    public Result listOperations() {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (o:Operation) RETURN o AS Operations");
    }

    public Result findFirefighter(String id) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (f:Firefighter) WHERE f.id = " + id + " RETURN f AS FireFighter");
    }

    public Result findCar(String id) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (c:Car) WHERE c.id = " + id + " RETURN c AS Car");
    }

    public Result findOperation(String id) {
        graphDatabaseService.beginTx();
        return graphDatabaseService.execute(
                "MATCH (o:Operation) WHERE o.id = " + id + " RETURN o AS Operation");
    }
}

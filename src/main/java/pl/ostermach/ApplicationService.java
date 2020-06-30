package pl.ostermach;

import org.neo4j.graphdb.Result;
import pl.ostermach.models.Car;
import pl.ostermach.models.Firefighter;
import pl.ostermach.models.Operation;


public class ApplicationService extends AbstractService {
    private final FirefighterUtils firefighterUtils;
    public ApplicationService() {
        super();
        firefighterUtils = new FirefighterUtils(graphDatabaseService);
    }


    public void addNewEntry() {
        System.out.println("[1] Firefighter\n[2] Car\n[3] Operation");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                Firefighter firefighter = FireBuilder.buildFirefighterList().get(0);
                firefighterUtils.saveFirefighterDate(firefighter);
                break;
            case 2:
                Car car = FireBuilder.buildCar();
                firefighterUtils.saveCarDate(car);
                break;
            case 3:
                Operation operation = FireBuilder.buildOperation();
                firefighterUtils.saveOperationDate(operation);
                break;
        }

    }

    public void deleteEntry() {
        System.out.println("[1] Firefighter\n[2] Car\n[3] Operation");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id:   ");
                firefighterUtils.deleteFirefighter(in.nextLine());
                break;
            case 2:
                System.out.println("Enter id:   ");
                firefighterUtils.deleteCar(in.nextLine());
                break;
            case 3:
                System.out.println("Enter id:   ");
                firefighterUtils.deleteOperation(in.nextLine());
                break;
        }
    }


    public void findById() {
        System.out.println("[1] Firefighter\n[2] Car\n[3] Operation");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id:   ");
                Result rows = firefighterUtils.findFirefighter(in.nextLine());
                System.out.println(rows.resultAsString());

                break;
            case 2:
                System.out.println("Enter id:   ");
                rows = firefighterUtils.findCar(in.nextLine());
                System.out.println(rows.resultAsString());

                break;
            case 3:
                System.out.println("Enter id:   ");
                rows = firefighterUtils.findOperation(in.nextLine());
                System.out.println(rows.resultAsString());
                break;
        }
    }

    public void getEntries() {
        System.out.println("[1] Firefighter\n[2] Car\n[3] Operation");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                firefighterUtils.listFirefighters();
                System.out.println(firefighterUtils.listFirefighters().resultAsString());
                break;
            case 2:
                firefighterUtils.listCars();
                System.out.println(firefighterUtils.listCars().resultAsString());
                break;
            case 3:
                firefighterUtils.listOperations();
                System.out.println(firefighterUtils.listOperations().resultAsString());
                break;
        }
    }

    public void updateEntry() {
        System.out.println("[1] Firefighter\n[2] Car\n[3] Operation");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id:   ");
                firefighterUtils.updateFirefighter(Integer.parseInt(in.nextLine()),FireBuilder.buildFirefighterList().get(0));
                System.out.println("Updated firefighter row...");
                break;
            case 2:
                System.out.println("Enter id");
                firefighterUtils.updateCar(Integer.parseInt(in.nextLine()),FireBuilder.buildCar());
                System.out.println("Updated car row...");
                break;
            case 3:
                System.out.println("Enter id:   ");
                firefighterUtils.updateOperation(Integer.parseInt(in.nextLine()),FireBuilder.buildOperation());
                System.out.println("Updated operation row...");
                break;
        }
    }
}
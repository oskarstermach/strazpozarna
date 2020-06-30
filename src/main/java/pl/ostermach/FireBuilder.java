package pl.ostermach;

import pl.ostermach.models.Firefighter;
import pl.ostermach.models.Operation;
import pl.ostermach.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FireBuilder {
    private static final Scanner in = new Scanner(System.in);

    public static Operation buildOperation() {
        Operation operation = new Operation();
        System.out.print("Enter type of operation:  ");
        operation.setName(in.nextLine());
        System.out.print("Enter date of report:  ");
        operation.setDate(in.nextLine());
        System.out.print("Enter target location:  ");
        operation.setLocation(in.nextLine());
        operation.setId((int) (Math.random() * 500) + 1);
        return operation;
    }

    public static List<Firefighter> buildFirefighterList() {
      //  boolean buildFirefighter = true;
        List<Firefighter> firefighterList = new ArrayList<>();
      //  while (buildFirefighter) {
            Firefighter firefighter = new Firefighter();
            System.out.print("Enter Firefighter's age:  ");
            firefighter.setAge(Integer.parseInt(in.nextLine()));
            System.out.print("Enter Firefighter's first name:  ");
            firefighter.setFirstName(in.nextLine());
            System.out.print("Enter Firefighter's last name:  ");
            firefighter.setLastName(in.nextLine());
            firefighter.setId((int) (Math.random() * 500) + 1);
            firefighterList.add(firefighter);

         //   System.out.print("Enter q to stop adding");
          //  if (in.nextLine().equals("q")) {
               // buildFirefighter = false;
          //  }
      //  }
        return firefighterList;
    }

    public static Car buildCar(){
        Car car = new Car();
        System.out.print("Enter car's plate:  ");
        car.setPlate(in.nextLine());
        System.out.print("Enter car's type:   ");
        car.setName(in.nextLine());
        car.setId((int) (Math.random() * 500) + 1);
        return car;
    }

}

package ua.training;

import ua.training.entities.Car;
import ua.training.entities.Truck;
import ua.training.annotation.AnnotationProcessor;


import static ua.training.ClassInfo.printDeclaredFieldsInfo;
import static ua.training.ClassInfo.printImplementedInterfacesInfo;

public class App {

    public static void main( String[] args ) throws Exception{
        Car car = new Car("Mercedes", 500, 7);
        System.out.println(car);
        Car truck = new Truck("Truck", 500, 7, 1500);
        System.out.println(truck );
        System.out.println("\n-----------------\nAnnotation work for truck:\n");
        System.out.println(AnnotationProcessor.collectInfo(truck));

        System.out.println("\n-----------------\nImplemented interfaces for Truck.class:");
        printImplementedInterfacesInfo(Truck.class);
        System.out.println("\n-----------------\nField info for Car.class:\n");
        printDeclaredFieldsInfo(Car.class);

    }
}

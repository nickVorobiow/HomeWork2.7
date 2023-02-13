package com.company;
import transport.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws TransportTypeException {
        Mechanic mechanic1 = new Mechanic("Nikita", "A");
        Mechanic mechanic2 = new Mechanic("Kirill", "B");
        Mechanic mechanic3 = new Mechanic("Artem", "C");
        Mechanic mechanic4 = new Mechanic("Vlad", "D");
        Mechanic mechanic5 = new Mechanic("John", "E");

        List<Mechanic> mechanicList = new ArrayList<>();
        mechanicList.add(mechanic1);
        mechanicList.add(mechanic2);
        mechanicList.add(mechanic3);
        mechanicList.add(mechanic4);
        mechanicList.add(mechanic5);


        CarDriver driver1 = new CarDriver("driver1", true, 5);
        Car.BodyType bodyType1 = Car.BodyType.valueOf("SEDAN");
        Car.BodyType bodyType2 = Car.BodyType.valueOf("COUPE");

        Car car1 = new Car("Audi", "A5", "3.0", driver1, bodyType1, mechanicList);
        Car car2 = new Car("Maseratti", "Granturismo", "4.4", driver1, bodyType2, mechanicList);
        Car car3 = new Car("Mitsubishi", "Evolution", "2.0", driver1, bodyType1, mechanicList);
        Car car4 = new Car("Nissan", "r32", "2.6", driver1, bodyType2, mechanicList);


        BusDriver driver2 = new BusDriver("driver2", true, 6);
        Bus.Capacity capacity1 = Bus.Capacity.valueOf("specialSmall");
        Bus.Capacity capacity2 = Bus.Capacity.valueOf("small");
        Bus.Capacity capacity3 = Bus.Capacity.valueOf("middle");
        Bus.Capacity capacity4 = Bus.Capacity.valueOf("large");

        Bus bus1 = new Bus("Mercedes", "merin", "7.0", driver2, capacity1, mechanicList);
        Bus bus2 = new Bus("VW", "wag", "6.0", driver2, capacity2, mechanicList);
        Bus bus3 = new Bus("LiAZ", "2023", "8.0", driver2, capacity3, mechanicList);
        Bus bus4 = new Bus("Great Wall", "modelX", "10.0", driver2, capacity4, mechanicList);

        CargoDriver driver3 = new CargoDriver("driver3", true, 7);
        Cargo.Tonnage tonnage1 = Cargo.Tonnage.valueOf("N1");
        Cargo.Tonnage tonnage2 = Cargo.Tonnage.valueOf("N2");
        Cargo.Tonnage tonnage3 = Cargo.Tonnage.valueOf("N3");

        Cargo cargo1 = new Cargo("KamAz", "KamAZ_2023", "5.0", driver3, tonnage1, mechanicList);
        Cargo cargo2 = new Cargo("Tatra", "model_X", "3.5", driver3, tonnage2, mechanicList);
        Cargo cargo3 = new Cargo("Skoda", "Racing cargo model", "4.0", driver3, tonnage3, mechanicList);
        Cargo cargo4 = new Cargo("Mitsubishi", "L200", "3.0", driver3, tonnage1, mechanicList);

        System.out.println(car1);
        System.out.println(bus1);
        System.out.println(cargo1 + "\n");

        bus2.startMove();
        bus2.stopMove();

        System.out.println();
        printMessage(car1);
        printMessage(cargo1);
        printMessage(bus1);


        System.out.println();
        car1.printType();
        bus1.printType();
        cargo1.printType();

        System.out.println();
        try {
            car2.passDiagnostics();
            cargo2.passDiagnostics();
            bus2.passDiagnostics();
        } catch (TransportTypeException e) {
            e.printStackTrace();
        }

        System.out.println();
        List<Transport> transportList = new ArrayList<>();
        transportList.add(car1);
        transportList.add(car2);
        transportList.add(car3);
        transportList.add(car4);
        transportList.add(cargo1);
        transportList.add(cargo2);
        transportList.add(cargo3);
        transportList.add(cargo4);
        transportList.add(bus1);
        transportList.add(bus2);
        transportList.add(bus3);
        transportList.add(bus4);

        for (Transport transport : transportList) {
            System.out.println(transport);
        }

        System.out.println("\n---------------------------------------");
        Queue<Transport> transportQueue = new LinkedList<>(transportList);
        ServiceStation serviceStation = new ServiceStation(transportQueue);
        try {
            serviceStation.doDiagnostics();
        } catch (TransportTypeException e) {
            e.printStackTrace();
        }
    }

    private static void printMessage(Transport<? extends Driver> transport) {
        System.out.println("Водитель " + transport.getDriver().getFullName() +
                " управляет автомобилем " + transport.getBrand() + " " + transport.getModel()
                + " и будет участвовать в заезде");
    }
}

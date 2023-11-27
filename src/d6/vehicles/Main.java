package d6.vehicles;

public class Main {
    public static void main(String[] args) {
        /*
        Car sonata = new Car();
        refuel(sonata);
        System.out.println(sonata.getFuel());
        sonata.drive(100);
        sonata.beep();

        Truck porter = new Truck(100);
        refuel(porter);
        System.out.println(porter.getFuel());
        porter.beep();
        porter.addLoad(30);
        porter.drive(100);
        System.out.println(String.format(
                "max load: %d, current load: %d",
                porter.getMaxLoad(), porter.getLoad())
        );

        Car bongo = new Truck(100);
        ((Truck) bongo).addLoad(10);
        if (isTruck(bongo))
            ((Truck) bongo).addLoad(10);
        else System.out.println("is not truck");

//        porter.drive(30);
//
//        refuel(bongo);
//        bongo.drive(100);
         */
        // 단순 상속
        Car sonata = new Car(100);
        Truck porter = new Truck(100);
        Car bongo = new Truck(100);
        refuel(porter);
        refuel(bongo);
        porter.addLoad(30);
        if (bongo instanceof Truck)
            ((Truck) bongo).addLoad(50);

        sonata.drive(100);
        porter.drive(100);
        bongo.drive(100);

        Car car = new Car();
        Ship ship = new Ship();
        makeNoise(car);
        makeNoise(ship);
    }
    public static boolean isTruck(Car car) {
        return car instanceof Truck;
    }

    public static void refuel(Car car) {
        car.setFuel(100);
    }

    public static void makeNoise(Beeper beeper) {
        beeper.beep();
    }

}

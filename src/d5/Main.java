package d5;


public class Main {
    public static void main(String[] args) {
        // 클래스 개요
        PublicCar myCar = new PublicCar();
        PublicCar.count += 1;
        myCar.brand = "Kia";
        myCar.name = "K5";
        myCar.fuel = 72;
        myCar.beep();
        myCar.printInfo();
        myCar.drive(10);
        System.out.println(PublicCar.count);

        PublicCar car = new PublicCar();
        PublicCar.count += 1;
        car.brand = "Hyundai";
        car.name = "Sonata";
        car.fuel = 80;
        car.printInfo();
        System.out.println(PublicCar.count);

        // 접근 제어자
        PublicCar somePublicCar = new PublicCar();
        PublicCar.count += 1;
        somePublicCar.name = "K3";
        somePublicCar.brand = "Kia";
        somePublicCar.fuel = 60;
        somePublicCar.printInfo();

        // ???????
        somePublicCar.brand = "Mercedes-Benz";
        somePublicCar.name = "E-Class";
        somePublicCar.printInfo();

        PrivateCar someCar = new PrivateCar("K5", "Kia", 72);
        // someCar.name = "K5";
        // someCar.brand = "Kia";
        // someCar.fuel = 72;
        System.out.println(someCar.getBrand());
        someCar.printInfo();
        someCar.setFuel(100);
        someCar.printInfo();

        PrivateCar sonata = new PrivateCar();
        sonata.setFuel(140);
        sonata.printInfo();
        System.out.println("total cars: " + PrivateCar.getCount());


        Person me = new Person("Jeeho Park");
        for (int i = 0; i < 40; i++) {
            me.age();
        }
        System.out.println(me.getAge());
        me.sayHello();

        // Pass by Value vs Pass by Reference
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);

        refuel(someCar);
        System.out.println(someCar.getFuel());
    }

    public static void refuel(PrivateCar privateCar) {
        privateCar.setFuel(150000);
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}

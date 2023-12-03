# Inheritance Basics

<!-- TOC -->
* [Inheritance Basics](#inheritance-basics)
  * [`extends`](#extends)
  * [Method Overriding](#method-overriding)
  * [`abstract class`](#abstract-class)
  * [`interface`](#interface)
<!-- TOC -->

## `extends`

Java에서는 클래스를 상속받아 본래 만들어져 있던 기능을 재사용할 수 있다. 이때 사용하는 키워드가 `extends`이다.
아래의 `Car` 클래스를,

```java
// Car.java

public class Car {
    private static int count = 0;
    private int fuel;

    public void beep() {
        System.out.println("빵빵");
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void drive(int kilos) {
        this.fuel -= kilos / 10;
    }
}
```

비슷한 기능을 가진 `Truck` 클래스를 만드는데 다시 활용해 보자.

```java
// Truck.java

public class Truck extends Car {}
```

`Truck`은 일종의 `Car`가 된다. (`Truck` is a `Car`) `Car`가 필요한 곳이라면 `Truck`을 활용할 수 있다.
하지만 `Truck`이 필요한 곳에 `Car`가 올수는 없다.
이때, `Truck`은 `Car`의 자식 클래스, `Car`는 `Truck`의 부모 클래스가 된다.

```java
// Main.java

public static void main(String[] args) {
    Car porter = new Truck();
    porter.beep();
    refuel(porter);
}

public static void refuel(Car car) {
    car.setFuel(100);
}
```

그 외에 `Car`는 가질 수 없는 기능을 `Truck`에만 부여할 수 있다.

```java
// Truck.java

public class Truck extends Car {
    private final int maxLoad;
    private int load;
    // ...
    public boolean addLoad(int load) {
        if (this.load + load > maxLoad) return false;
        this.load += load;
        return true;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public int getLoad() {
        return load;
    }
}
```

단, `Car`로 선언된 변수에 들어간 `Truck`은 `Car`로 취급된다. 만약 `Car`에 들어간 객체가 `Truck`임을 알고 있다면, **Downcasting**이 가능하다.

```java
// Main.java

Car porter = new Truck();
porter.beep();
refuel(new Truck());

// porter.addLoad(10);  // error
((Truck) porter).addLoad(10);
```

만약 할당된 객체가 `Truck`이 맞는지 확인하고 싶다면 `instanceof`를 사용해보자.

```java
// Main.java

Car sonata = new Car();

// before java 14
if (sonata instanceof Truck)
    ((Truck) sonata).addLoad(10);
else System.out.println("Can't do that!");

// after java 14
if (sonata instanceof Truck truck)
    truck.addLoad(10);
else System.out.println("Can't do that!");
```

## Method Overriding

자식 클래스는 필요에 따라 부모 클래스의 메서드를 덮어쓸 수 있다. 이를 메서드 오버라이딩이라 한다.
이때, `@Override`를 붙여 덮어쓴(Override한) 메서드임을 나타낼 수 있다.

오버라이드한 상태에서 부모 클래스가 가진 메서드를 똑같이 호출하고 싶다면 `super`를 사용할 수 있다.
`super`는 부모 객체를 나타내는 키워드이다.

```java
// Truck.java

@Override
public void drive(int kilos) {
    super.drive(kilos);
}
```

`super`를 사용하면 부모 클래스의 생성자를 호출할수도 있다.

```java
// Truck.java

public Truck(int fuel, int maxLoad, int load) {
    super(fuel);
    this.maxLoad = maxLoad;
    this.load = load;
}
```

`super`를 사용해도 `private` 속성은 접근이 불가하다. 만약 자식 객체가 자유로이 접근할 수 있는 속성, 메서드를 만들고 싶다면 `protected`를 사용해주자.

```java
// Car.java

public class Car {
    // ...
    protected int fuel;
    // ...
}

// Truck.java
public class Truck {
    @Override
    public void drive(int kilos) {
        super.drive(kilos);
        fuel -= load / (maxLoad / 10);
    }
}
```

---

구상 클래스(Concrete Class)를 직접 상속받는 것 부모와 자식간의 결합성(Coupling)을 강하게 한다.
대신 Java에서는 좀더 추상화된 추상 클래스(`abstract class`)와 인터페이스(`interface`)를 제공한다.

## `abstract class`

추상 클래스는 구현되지 않은 메서드를 가질 수 있는 클래스이며, 직접 객체를 만들 수 없다.
오로지 자신을 상속받은 자식 클래스만 새로운 객체를 만들 수 있다.

```java
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    // 추상 메서드
    public abstract void sayHello();

    public String getName() {
        return name;
    }
}
```

여러 클래스의 기본 바탕이 되는 클래스를 만들기 위해 많이 활용하며, 공통 기능과 상속받은 클래스가 직접 구현해야 하는 기능을 정의한다.
`abstract`가 붙은 메서드는 실제로 구현된 메서드가 아니며, 상속받은 클래스가 각각 구현해야 한다.

```java
// Student.java
public class Student extends Person {
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public void sayHello() {
        System.out.println(String.format(
                "Hello, I'm %s, and studying %s!",
                getName(), major));
    }
}

// Lecturer.java
public class Lecturer extends Person {
    private String subject;

    public Lecturer(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void sayHello() {
        System.out.println(String.format(
                "Hello, I'm %s, today's subject is %s.",
                getName(), subject));
    }
}
```

자식 클래스들이 일정한 기능을 가지고 있음을 보장할 수 있다.

```java
Person alex = new Student("Alex", "CSE");
Person brad = new Lecturer("Brad", "OOP");

alex.sayHello();
brad.sayHello();
```

## `interface`

인터페이스(`interface`)는 어떤 정보나 기능을 공유하지 않고, 어떤 기능을 구현해야 하는지만 정의된 추상 메서드의 모음이다.
인터페이스를 구현(`implement`)하는 클래스는 인터페이스의 메서드를 반드시 구현해야 한다.

```java
// Car.java

public class Car {
    public void beep() {
        System.out.println("빵빵");
    }
}

// Ship.java

public class Ship {
    public void beep(){
        System.out.println("부아아아아앙");
    }
}
```

큰 연관성이 적은 클래스가 동일한 기능을 가지고 있다는걸 표현하기 위해 활용할 수 있다.
이때 인터페이스를 구현한다는 의미로 `implements`를 사용한다.

```java
// Beeper.java
public interface Beeper {
    void beep();
}

// Car.java
public class Car implements Beeper {
    // ...
    @Override
    public void beep() {
        System.out.println("빵빵");
    }
}

// Ship.java
public class Ship implements Beeper {
    // ...
    @Override
    public void beep(){
        System.out.println("부아아아아앙");
    }
}
```

어떤 인터페이스가 필요한 상황이라면, 둘중 아무 클래스나 전달할 수 있다.

```java
public static void main(String[] args) {
    Car sonata = new Car(100);
    Ship ship = new Ship();
    makeNoise(sonata);
    makeNoise(ship);
}

public static void makeNoise(Beeper beeper) {
    beeper.beep();
}
```

하나의 클래스는 하나의 클래스만 상속 가능하지만, 인터페이스는 여럿을 상속받을 수 있다.


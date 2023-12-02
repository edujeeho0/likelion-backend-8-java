# 클래스

데이터와 행동을 하나의 단위로 묶어서 객체로 활용하기 위한 설계도.

<!-- TOC -->
* [클래스](#클래스)
  * [클래스 만들기](#클래스-만들기)
    * [속성(attribute)](#속성attribute)
    * [메서드(method)](#메서드method)
    * [정적(`static`) 제어자](#정적static-제어자)
  * [접근 제어자](#접근-제어자)
    * [`public` & `private`](#public--private)
    * [Getter & Setter](#getter--setter)
    * [생성자(Constructor)](#생성자constructor)
  * [Wrapper Class](#wrapper-class)
    * [유용한 메서드들](#유용한-메서드들)
<!-- TOC -->

## 클래스 만들기

하나의 파일에 여러 클래스를 만들 수 있으나, 기본적으로 하나의 클래스를 하나의 파일에 정의한다.

```java
// Car.java 파일에 새로 만든다. 
public class Car {
}
```

클래스를 바탕으로 객체를 만들 수 있다. 이렇게 만들어진 객체를 특정 클래스의 인스턴스라고 부른다.

```java
public static void main(String[] args) {
    Car myCar = new Car();
}
```

### 속성(attribute)

하나의 객체가 가질 수 있는 성질 또는 데이터. 클래스 내부에 정의한다.

```java
public class Car {
    public String name;
    public String brand;
    public int fuel;
}
```

변수를 메서드 내부가 아닌 클래스 내부에 선언한다. 다른곳에서는 `.`을 이용해 접근한다.

```java
public static void main(String[] args) {
    Car myCar1 = new Car();
    // 속성에 `.`을 이용해 접근하고,
    // 변수에 데이터를 할당하듯
    // 속성에 데이터를 할당할 수 있다.
    myCar1.name = "K5";
    myCar1.brand = "Kia";
    myCar1.fuel = 72;
    // 값을 가져올때도 `.`을 통해 가져온다.
    System.out.println(
        String.format("My car name is: %s", myCar1.name));
}
```

### 메서드(method)

객체에서 반복해서 활용할 기능, 동작. [메서드](../methods.md)와 동일하나, 기본적으로 `static`을 생략한다.

```java
public class Car {
    public String name;
    public String brand;
    public int fuel;

    public void printInfo() {
        System.out.println(String.format(
                "name:\t%s\nbrand:\t%s\nfuel:\t%s",
                name, brand, fuel
        ));
    }
}
```

속성과 마찬가지로 `.`을 활용해 호출.

```java
public static void main(String[] args) {
    Car myCar1 = new Car();
    myCar1.name = "K5";
    myCar1.brand = "Kia";
    myCar1.fuel = 72;
    myCar1.printInfo();

    Car myCar2 = new Car();
    myCar2.name = "Sonata";
    myCar2.brand = "Hyundai";
    myCar2.fuel = 60;
    myCar2.printInfo();
}
```

### 정적(`static`) 제어자

정적 = 움직이지 않는다는 뜻. `static`이 붙은 속성, 메서드는 개별 인스턴스가 아닌 클래스에 속한다.
인스턴스를 만들지 않고 접근이 가능.

```java
public class Car {
    public static int count = 0;
    public String name;
    public String brand;
    public int fuel;
    // ...
}
```

객체가 몇개나 만들어졌는지, 단순 기능 모음(`Arrays` 클래스 등) 등에 활용 가능

```java
Car myCar1 = new Car();
Car.count++;

Car myCar2 = new Car();
Car.count++;
System.out.println(Car.count);
```

더 공부하고 싶다면 **정적 팩토리 메서드**, **싱글턴 패턴** 등도 찾아보자.

## 접근 제어자

지금까지의 코드는 코드 상에서 아무나 접근할 수 있다.

```java
public static void main(String[] args) {
    Car someCar = new Car();
    someCar.name = "K5";
    someCar.brand = "Kia";
    someCar.fuel = 72;
    someCar.printInfo();

    // ????
    someCar.name = "E-Class";
    someCar.brand = "Mercedes-Benz";
    someCar.printInfo();
}
```

하지만 실제로는 개발자가 접근할 수 있는 부분을 한정지을 필요가 있다.

### `public` & `private`

`public` 대신 `private`을 사용하면, 클래스 밖에서는 직접적으로 접근이 불가하다.

```java
public class Car {
    private String name;
    private String brand;
    private int fuel;

    public void printInfo() {
        System.out.println(String.format(
                "name:\t%s\nbrand:\t%s\nfuel:\t%s",
                name, brand, fuel
        ));
    }
}
```

- `public` : 객체에 접근할 수 있다면, `public` 접근 제어자가 붙은 변수와 메서드도 접근 가능.
- `private` : 클래스 내부에서만 접근 가능.

### Getter & Setter

`private` 으로 설정된 속성등에 접근하기 위해 `public` 메서드를 만들어 속성의 값을 반환하게 만들 수 있다.

```java
public class Car {
    private String name;
    private String brand;
    // ...

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
    // ...
}
```

```java
Car someCar = new Car();
System.out.println(someCar.getBrand());
System.out.println(someCar.getName());
```

이런 메서드를 Getter 메서드라 부른다.

반대로 외부에서 자유롭게 속성을 변경 가능하게 하고 싶다면, Setter 메서드를 만들 수 있다.

```java
public class Car {
    // ...
    private int fuel;

    // ...

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        // this 키워드로 객체를 가르켜
        // 매개변수 fuel과의 충돌을 피한다.
        this.fuel = fuel;
    }
    // ...
}
```

### 생성자(Constructor)

객체를 생성할 때 호출되는 메서드. `public <클래스명>(<매개변수 목록>)`의 형태로 정의.

```java
public class Car {

    private String name;
    private String brand;
    private int fuel;

    public Car(String name, String brand, int fuel) {
        this.name = name;
        this.brand = brand;
        this.fuel = fuel;
    }

    // ...
}
```

`new` 키워드를 통해 객체를 만들때 호출된다.

```java
Car someCar = new Car("K5", "Kia", 72);
System.out.println(someCar.getName());
System.out.println(someCar.getBrand());
someCar.setFuel(72);
System.out.println(someCar.getFuel());
```

## Wrapper Class

`int`, `char`, `boolean`과 같은 자료형은 클래스가 아닌 원시타입이다.
이들을 객체지향적 관점에서 활용할 수 있도록 해주는 클래스를 Wrapper Class라 부른다.

```java
// String.format 같은 다양한 기능이 내장되어 있다.
Integer parsedInt = Integer.parseInt("1024");
Double infinity = Double.POSITIVE_INFINITY;
System.out.println(Character.isLetter('a'));
System.out.println(Character.isDigit('1'));
```

`class`의 개념을 가지고 만들어진 참조 타입이지만, 원시 타입 자료형을 사용하듯 활용 가능.
이를 *Autoboxing and Unboxing*이라 부른다.

```java
// 그냥 값을 할당할 수 있고,
Integer intWrapper = 10;
Double doubleWrapper = 2.5;

// 사칙연산도 가능하며
Integer result = intWrapper + 25;
Double doubleResult = (double) intWrapper / 5;

// 서로 상호 호환도 된다!
long longPrimitive = 100000L;
Long longWrapper = longPrimitive;
longPrimitive = longWrapper * 2;
```

### 유용한 메서드들

| 메서드                                | 기능                                 |
|------------------------------------|------------------------------------|
| `Integer.parseInt(String s)`       | 문자열이 나타내는 정수를 반환한다.                |
| `Double.parseDouble(String s)`     | 문자열이 나타내는 실수를 반환한다.                |
| `Character.isDigit(char ch)`       | 문자가 숫자를 나타내는지 확인한다.                |
| `Character.isLetter(char ch)`      | 문자가 글자를 나타내는지 확인한다.                |
| `string.length()`                  | 문자열의 글자수를 반환한다.                    |
| `string.substring(int beginIndex)` | 문자열을 `beginIndex` 부터 자른 문자열을 반환한다. |
| `string.charAt(int index)`         | 문자열의 `index` 위치의 `char를` 반환한다.     |
| `string.indexOf(String str)`       | 주어진 문자열이 시작하는 `index를` 반환한다.       |
| `string.split(String regex)`       | 주어진 정규표현식을 기준으로 문자열을 나눠 배열로 반환한다.  |


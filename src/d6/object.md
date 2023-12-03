# `Object` class

<!-- TOC -->
* [`Object` class](#object-class)
  * [`toString`](#tostring)
  * [`equals`](#equals)
  * [`hashCode`](#hashcode)
* [`null`](#null)
<!-- TOC -->

`Object`는 Java의 클래스가 기본적으로 상속받는 클래스이다.
아무것도 상속받지 않는 클래스를 만든다면, 묵시적으로 `Object` 클래스를 상속받는다.

또한 `Object` 클래스는 Java내에서 여러가지 기능(예: 문자열 변환)을 위해 활용하는 메서드를 가지고 있으며,
자식 클래스에서 오버라이드 하여 클래스가 의도대로 동작하도록 정의할 수 있다.

아래의 메서드는 Intellij에서 자동으로 만들어주는 기능이 있으니 참고하자.

## `toString`

어떤 객체가 문자열로 어떻게 표현될지를 정의하는 메서드. 기본값은 객체가 메모리상 어디 저장되어 있는지를 돌려준다.
아래는 `Student` 객체의 예시.

```text
Student@3c69d57
```

자식 클래스에서 `toString`을 오버라이드 하면 `System.out.println()`의 인자로 전달될 때 출력될 모습을 정의할 수 있다.

```java
public abstract class Person implements Comparable{
    // ...
    @Override
    public String toString() {
        // name == "Alex", age == 20 일때
        // "Alex, age: 20"가 출력된다.
        return String.format("%s, age: %s", name, age);
    }
}
```

## `equals`

`==`는 일치 연산자로, 원시 타입을 비교할때는 괜찮지만 참조 타입을 비교할때는 문제가 될 수 있다.
객체가 가지고 있는 속성의 일치가 아닌, 실제로 동일하게 저장된 객체인지를 비교하기 때문이다.

```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Student("Alex", 20, "CSE");

// 같은 값을 가지고 있어도 false
System.out.println(alex == alex2);
```

각 객체가 가진 속성값을 기준으로 일치하는지를 비교하고 싶다면 `equals`를 오버라이드 할 수 있다.

```java
public abstract class Person {
    // ...
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}

```

비교를 할때 `equals`를 호출한다.

```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Student("Alex", 20, "CSE");

// false
System.out.println(alex == alex2);
// true
System.out.println(alex.equals(alex2));
```

상속관계가 있는 클래스의 `equals`를 구현할때는 주의를 요한다.
부모 클래스 입장에서는 동일하지만, 자식 클래스 입장에서는 동일하지 않을 수 있기 때문.

`Person.equals()`를 자식 클래스 구분없이 일치하는지 확인하도록 정의하고,

```java
// Person.java

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person person)) return false;
    return age == person.age && Objects.equals(name, person.name);
}
```

`Student.equals()`를 동일한 클래스일때만 일치하도록 정의하면

```java
// Student.java

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(major, student.major);
}
```

서로 다른 자식 클래스를 비교할 때 문제가 발생할 수 있다.

```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Lecturer("Alex", 20, "OOP");

System.out.println(alex.equals(alex2));  // false
System.out.println(alex2.equals(alex));  // true
```

## `hashCode`

`hashCode`는 Java 내부적으로 동일한 객체인지 아닌지를 비교하기 위해 사용한다. (Hash Code가 무엇인지는 검색해보자.)
Java에서는 `equals`를 오버라이드 했다면 `hashCode`도 오버라이드 하여,
`x.equals(y) == true` 일때 `x.hashCode() == y.hashCode()`이 성립하도록 권장하고 있다.

```java
public abstract class Person {
    // ...
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

# `null`

`null`은 존재하지 않는다는 것을 의미한다.
어떤 참조 타입 변수에 값이 할당되지 않으면, 해당 객체가 존재하지 않는다는 의미로 `null`이 할당된다.

```java
// 속성을 할당하지 않는 기본생성자를 만들고
Person noNamePerson = new Student();
// 할당되지 않은 속성을 확인해보자.
System.out.println(noNamePerson.getName());  // null
```

만약 어떤 객체가 `null`인 상태에서 그 메서드를 사용하려고 하면, `NullPointerException`이 발생한다.

```java
Person noNamePerson = new Student();
// null
System.out.println(noNamePerson.getName());
// throws NullPointerException
System.out.println(noNamePerson.getName().equals("Alex"));
```

간단하게는 `if` 등의 조건문으로 방지하거나, 분명히 `null`이 아는 대상의 메서드를 기준으로 동작시킬 수 있다.

```java
Person noNamePerson = new Student();
System.out.println(noNamePerson.getName());
// System.out.println(noNamePerson.getName().equals("Alex"));
System.out.println("Alex".equals(noNamePerson.getName()));
```

Java 프로그래밍을 진행하면 `null`과 관련된 문제는 참으로 많이 만나게 된다. 주의가 필요하다.

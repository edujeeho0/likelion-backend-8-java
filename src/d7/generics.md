# Generic Type Reference

<!-- TOC -->
* [Generic Type Reference](#generic-type-reference)
  * [Generic 사용하기](#generic-사용하기)
  * [제한된 타입 파라미터](#제한된-타입-파라미터)
  * [`Optional<T>`](#optionalt)
<!-- TOC -->

Java 5 이후 클래스, 인터페이스, 메서드를 좀더 "일반적인 상황"에서 활용하고 재사용성을 높이는 방법

## Generic 사용하기

클래스를 정의하면서, 다이아몬드 연산자(`<>`)를 이용해 클래스 이름대신 사용할 매개변수를 작성해준다.
이를 타입 파라미터(Type Parameter)라 부른다.

```java
public class ArrayWrapper<T> {
}
```

이렇게 정의한 클래스는 내부에서 `T`를 일종의 클래스처럼 활용 가능하다.

```java
public class ArrayWrapper<T> {
    private final T[] array;

    public ArrayWrapper(T[] array) {
        if (array == null)
            throw new IllegalArgumentException("null array provided");
        this.array = array;
    }

    public int length() {
        return array.length;
    }

    public boolean contains(T target) {
        for (T item : array) {
            if (item == null) continue;
            if (item.equals(target)) return true;
        }
        return false;
    }
}
```

실제 `T`는 실행중에 결정된다.

```java
Integer[] intArray = {10, 20, 30};
ArrayWrapper<Integer> intArrayWrapper = new ArrayWrapper<>(intArray);
System.out.println(intArrayWrapper.length());
System.out.println(intArrayWrapper.contains(10));
System.out.println(intArrayWrapper.contains(15));

Double[] doubleArray = {1.0, 2.3, 4.5};
ArrayWrapper<Double> realArrayWrapper = new ArrayWrapper<>(doubleArray);
System.out.println(realArrayWrapper.length());
System.out.println(realArrayWrapper.contains(1.0));
System.out.println(realArrayWrapper.contains(2.4));
```

메서드에도 타입 파라미터를 정의해줄 수 있다.

```java
public static <T> boolean contains(T[] source, T target) {
    for (T item : source) {
        if (item == null) continue;
        if (item.equals(target)) return true;
    }
    return false;
}
```

## 제한된 타입 파라미터

만약 타입 파라미터로 전달되는 클래스가 특정 클래스 또는 인터페이스를 상속받는 클래스였으면 한다면,
`extends` 키워드를 활용해 타입 파라미터를 제한시킬 수 있다. 그러면 해당 클래스 또는 인터페이스의 메서드를,
메서드 구현에 활용 가능.

```java
// Comparable<T>의 T는 Comparable의 타입 파라미터가 아닌 ArrayWrapper의 파라미터 T
public class ArrayWrapper<T extends Comparable<T>> {
    // ...
    public T max() {
        T max = null;
        for (T item : array) {
            if (item == null) continue;
            if (max == null || item.compareTo(max) > 0) max = item;
        }
        return max;
    }
}
```

여러 클래스와 인터페이스를 상속받게 하고 싶다면 `&`로 구분해준다.
이때, Java의 클래스는 하나의 클래스만 상속받을 수 있으므로, 클래스를 제일 앞에 작성해준다.

```java
// Number는 클래스, 나머지는 인터페이스이다.
public class ArrayWrapper<T extends Number & Comparable<T> & Serializable> {
    // ...
}
```

## `Optional<T>`

Generic을 활용한 대표적인 예시. Java 8이후 Null Safety를 목표로 도입된 클래스이다.

아래 메서드는 50% 확률로 결과가 `null`이 된다.

```java
public static String nullOrString() {
    Random random = new Random();
    if (random.nextInt() % 2 == 0) 
        return "not null string";
    else return null;
}
```

이 메서드의 결과를 `Optional`로 덮어씌워, `null`일때와 아닐때를 구분할 수 있다.

```java
Optional<String> optionalString = Optional.ofNullable(nullOrString());
if (optionalString.isPresent()) {
    System.out.println(optionalString.get());
} else {
    System.out.println("got: null");
}
```

`if`와 같은 조건문으로 활용하는 것 외에도 `orElse`와 같은 "`null`일때 대처할 값"을 전달하는 방식으로도 활용 가능.

```java
String resultString = optionalString.orElse("got: null");
System.out.println(resultString);
```

메서드를 만들 때 `Optional`을 반환하게 만들수도 있다.

```java
public static Optional<String> nullOrStringOpt() {
    Random random = new Random();
    if (random.nextInt() % 2 == 0)
        return Optional.of("concrete string");
    else return Optional.empty();
}
```

```java
String resultString2 = nullOrStringOpt().orElse("got: null");
System.out.println(resultString2);
```

단 `Optional` 자체는 유용하나, 단순 `== null` 보다 작성할 코드 자체는 많아진다. 선택적으로 활용하자.

# Stream

Stream API는 Java 8 버전에 소개된, 데이터 모음을 다루는 방법 중 하나.

## Functional Interface

Java는 함수를 일급 객체로 취급하지 않는다. 대신 메서드를 하나만 갖는 함수형 인터페이스를 활용한다.

```java
// 이 @는 필수는 아니며, 오류 상황을 검사해줍니다.
@FunctionalInterface
public interface NoArgRetFunction {
    void noArgNoReturn();
}
```

이전에는 이를 익명 내부 클래스(anonymous inner class)로 활용했지만,
Java 8 버전부터는 람다 표현식(익명 함수)을 이용해 쉽게 표현할 수 있게 변경되었다.

```java
NoArgRetFunction lambda = () -> System.out.println("Hello Lambda!");
lambda.noArgNoReturn();

// 여러줄은 {}를 활용한다
NoArgRetFunction lambda = () -> {
    System.out.println("Hello Lambda!");
    System.out.println("Multiline Lambda!");
};
lambda.noArgNoReturn();
```

이렇게 만들어진 익명 함수는, 표현하는 함수형 인터페이스를 매개변수로 가지는 메서드에 인자로 전달 가능.

```java
public static void main(String[] args) {
    useFunction(() -> System.out.println("lambda as argument!!!"));
}

public static void useFunction(NoArgRetFunction function) {
    function.noArgNoReturn();
}
```

만약 어떤 특정 클래스 또는 객체의 메서드가 필요한 함수형 인터페이스의 형태와 동일할 경우
해당 메서드를 `::`로 참조 가능하다.

```java
@FunctionalInterface
public interface StringArgFunction {
    int run(String a);
}
```

```java
public static void main(String[] args) {
    useFunction(String::length);
}

public static void useFunction(StringArgFunction function) {
    System.out.println(function.run("lorem ipsum"));
}
```

Java 내부에는 여러 함수형 인터페이스가 미리 정의되어 있으며, 
이를 이용해 Stream API의 메서드에 전달하고 활용한다.

| 함수형 인터페이스    | 람다 표현식          | 실제 메서드                    |
|--------------|-----------------|---------------------------|
| `Function`   | `T -> R`        | `R apply(T t)`            |
| `Predicate`  | `T -> boolean`  | `boolean test(T t)`       |
| `Consumer`   | `T -> void`     | `void accept(T t)`        |
| `Supplier`   | `() -> T`       | `T get()`                 |
| `Comparator` | `(T, T) -> int` | `int compare(T o1, T o2)` |


## Stream 사용

Stream을 사용하는건 총 3단계로 이뤄진다.

1. [`Stream` 만들기](#stream-만들기)
2. [Intermediate Operation * N](#intermediate-operation)
3. [Terminal Operation](#terminal-operation)

### `Stream` 만들기

기본적으로 배열과 `Collection`은 편하게 `Stream`으로 전환이 가능하다.
배열은 `Arrays.stream`을 쓸 수 있다.

```java
String[] nameArray = {"Alex", "Dave", "Chad", "Brad"};
Stream<String> nameArrStream = Arrays.stream(nameArray);
```

원시 타입의 경우, 타입 파라미터로 넘기지 못하는 만큼, 별도의 클래스를 제공한다.
`char`의 경우 `IntStream`이 된다.

```java
int[] numbers = {1, 23, 14, 53, 22, 15, 10, 6};
IntStream intStream = Arrays.stream(numbers);
IntStream charStream = "edujeeho@gmail.com".chars();
```

`Collection`은 `stream()` 메서드를 활용할 수 있다.

```java
List<String> nameList = new ArrayList<>();
nameList.add("Alex");
nameList.add("Dave");
nameList.add("Chad");
nameList.add("Brad");
Stream<String> nameListStream = nameList.stream();
```

### Intermediate Operation

`Stream` 객체를 만들면 적용할 중간 작업을, 메서드 호출 및 함수 전달 식으로 사용한다.
중간 작업 메서드는 또다른 `Stream` 객체를 반환하며, 그 결과 메서드를 연속적으로 호출할 수 있다.
```java
Stream<String> nameListStream1
        = nameList.stream();
Stream<String> nameListStream2
        = nameListStream1.filter(name -> name.contains("a"));
Stream<String> nameListStream3
        = nameListStream2.sorted((o1, o2) -> o1.length() - o2.length());
```

```java
Stream<String> nameListStream = nameList.stream()
        .filter(name -> name.contains("a"))
        .sorted((o1, o2) -> o1.length() - o2.length());
```

#### `filter`

각 데이터를 인자로 받아 `boolean`을 반환하는 함수를 인자로 받는다.
함수의 결과가 `true`가 되는 데이터만 담은 `Stream`을 반환한다.

```java
// "a"가 담긴 nameList의 원소만 남은 Stream이 된다.
Stream<String> nameListStream = nameList.stream()
        .filter(name -> name.contains("a"));
```

#### `map`

각 데이터를 인자로 받아, 새로운 데이터를 반환하는 함수를 인자로 받는다.
함수의 결과들을 모은 `Stream`을 반환한다.

```java
nameList.stream()
        // "a"가 담긴 데이터만 남긴 뒤,
        .filter(name -> name.contains("a"))
        // 그 데이터를 전부 대문자로 변환한다.
        .map(name -> name.toUpperCase())
```

#### `sort`

데이터를 정렬한 새로운 `Stream`을 반환한다.

```java
// 알파벳 순으로 정렬된 Stream을 반환한다.
nameList.stream()
        .sorted();
```

`Comparator` 클래스의 정적 메서드를 통해 특정 방향을 정해주거나,

```java
// 알파벳 역순으로 정렬된 Stream을 반환한다.
nameList.stream()
        .sorted(Comparator.reverseOrder());
```

`Comparator` 역할의 익명 함수를 전달할 수 있다.

```java
// 각 데이터의 길이에 따라 정렬된 Stream을 반환한다.
nameList.stream()
        .sorted((o1, o2) -> o1.length() - o2.length())
```

### Terminal Operation

종결 작업은 최종적으로 `Stream`을 활용하고 싶은 형태로 변환해준다.

#### `foreach`

각 데이터를 반환이 없는 함수에 인자로 전달한다.

```java
// 각 데이터를 인자로 System.out.println로 호출한다.
nameListStream.forEach(System.out::println);
```

#### `count`

몇개의 데이터가 남았는지 계산한다.

```java
System.out.println(nameListStream.count());
```

#### `toList`

데이터를 새로운 리스트로 만들어 반환한다.

```java
List<String> result = nameListStream.toList();
```

#### `allMatch`, `anyMatch`, `noneMatch`

각각 전체 데이터를 주어진 함수의 인자로 전달하여, `boolean` 결과를 수집하여
`boolean`을 반환한다.
- `allMatch`: 모든 데이터에 대하여 전달된 함수가 `true` 일 때 `true`
- `anyMatch`: 모든 데이터 중 하나라도 전달된 함수의 결과가 `true` 일 때 `true`
- `noneMatch`: 모든 데이터에 대하여 전달된 함수가 `false` 일 때 `false`

```java
// 실제 상황에서는 각각 따로 실행해야 한다.
boolean allMatch = nameListStream.allMatch(name -> name.contains("a"));
System.out.println(allMatch);

boolean anyMatch = nameListStream.anyMatch(name -> name.contains("e"));
System.out.println(anyMatch);

boolean noneMatch = nameListStream.noneMatch(name -> !name.contains("a"));
System.out.println(noneMatch);
```

---

`IntStream`과 같은 원시타입 숫자 `Stream`은 집계를 위한 메서드도 제공된다.

#### `sum`

원소들의 총합을 반환한다.

```java
System.out.println(intStream.sum());
```

#### `min`, `max`, `avg`

각각 최소, 최대, 평균을 반환하되, `Stream`이 비어있을 경우를 대비하여 `Optional`의 형태로 결과가 반환된다.

```java
// 실제 상황에서는 각각 따로 실행해야 한다.

System.out.println(intStream.min());
System.out.println(intStream.max());
System.out.println(intStream.average());
```
```java
IntStream intStream = Arrays.stream(new int[]{});
// OptionalDouble.empty
System.out.println(intStream.average());  
```
---

종결 작업 이후에는 `Stream`을 다시 사용할 수 없다. 다시 메서드를 호출하면 `IllegalStateException` 발생.

```java
Stream<String> nameListStream = nameList.stream()
        .filter(name -> name.contains("a"))
        .sorted((o1, o2) -> o1.length() - o2.length());
System.out.println(nameListStream.allMatch(name -> name.length() > 0));
// 여기서 IllegalStateException 발생
nameListStream.filter(name -> name.contains("d"));
```

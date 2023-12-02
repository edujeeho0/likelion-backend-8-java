# 제어문

<!-- TOC -->
* [제어문](#제어문)
  * [조건문](#조건문)
    * [`if`](#if)
    * [`else`](#else)
    * [`else if`](#else-if)
    * [`switch` - `case`](#switch---case)
  * [반복문](#반복문)
    * [`while`](#while)
    * [`for`](#for)
    * [`foreach` (enhanced `for`)](#foreach-enhanced-for)
    * [반복문 제어](#반복문-제어)
<!-- TOC -->

## 조건문

특정 조건에 대해서만 코드를 작성하고 싶을 때 사용한다.

### `if`

어떤 주어진 조건이 참(`true`)일때만 실행하는 코드

```java
int age = 25;
if (age < 20) {
    System.out.println("You cannot enter");
}
```

제어문을 비롯해 Java의 코드는 영역을 `{}`로 구분하는 경우가 많다. `if` 내부에 새로운 `if` 가 들어갈 수도 있다.

```java
// 효율적이진 않은 중첩 조건문 예시
int year = 2023;
if (year % 4 == 0) {
    System.out.println("윤년일까?");
    if (year % 100 != 0) {
        System.out.println("윤년이다.");
    }
    if (year % 100 == 0 && year % 400 != 0) {
        System.out.println("윤년 아니다.");
    }
    if (year % 400 == 0) {
        System.out.println("윤년이다.");
    }
}
```

### `else`

`if`에 주어진 조건이 `false`일 때 실행하는 코드. `if` 없이 `else`만 사용할순 없다.

```java
int number = 10;
if (number % 2 == 0) {
    System.out.println("number is even");
}
else {
    System.out.println("number is odd");
}
```

### `else if`

한가지 이상의 조건을 검증하고 싶을 때 `if` 이후 여러번 활용해, `if`가 거짓일 때 검증할 추가 조건을 묘사할 수 있다.
여러번 반복해서 활용 가능.

```java
int dust = 20;
if (dust < 15) {
    System.out.println("Good");
}
else if (dust < 35) {
    System.out.println("Normal");
}
else if (dust < 75) {
    System.out.println("Bad");
}
else {
    System.out.println("Very Bad");
}
```

한번이라도 조건이 `true`라면 이후의 `else if`의 조건은 확인하지 않는다.

```java
int zero = 0;
if (zero == 0) {
    System.out.println("is zero");
} else if (10 % zero == 0) {
    System.out.println("is factor");
} else {
    System.out.println("is not factor");
}
```

### `switch` - `case`

확인할 조건이 *어떤 특정 값과 일치하는지* 일때 활용하는 조건문

```java
String input = scanner.nextLine();
switch (input) {
    case "w":
        System.out.println("up");
        break;
    case "a":
        System.out.println("left");
        break;
    case "s":
        System.out.println("down");
        break;
    case "d":
        System.out.println("right");
        break;
    default:
        System.out.println("bad input");
        break;
}
```

Java 14 Enhanced Switch. 더 많은 기능이 있으므로 찾아볼 가치가 있다.

```java
switch (input) {
    case "w" ->
            System.out.println("up");
    case "a" ->
            System.out.println("left");
    case "s" ->
            System.out.println("down");
    case "d" ->
            System.out.println("right");
    default ->
        System.out.println("bad input");
}
```

## 반복문

특정 조건을 만족할때 똑같은 코드를 반복해서 실행하는 제어문

### `while`

어떤 주어진 조건이 `true`인 동안 반복하는 반복문

```java
int loan = 1000;
while (loan > 0) {
    loan -= 50;
    loan *= 1.03;
    System.out.println("paid off 50, remains: " + loan);
}
System.out.println("no more loans!");
```

괄호 내부의 조건이 `true`라면 계속 수행되므로, 내부 코드에서 언젠간 `false`가 될 수 있는 코드를 작성해 주어야 한다.
그렇지 않으면 무한히 반복하게 된다.

```java
// loan == 1717 일때부터 무한루프
int loan = 1717;
while (loan > 0) {
    int payoff = 50;
    if (loan < 50) {
        payoff = loan;
        loan = 0;
    }
    else {
        loan -= 50;
    }
    loan *= 1.03;
    System.out.println(String.format("paid off %d, remains: %d", payoff, loan));
}
System.out.println("no more loans!");
```

### `for`

세 부분으로 나누어서 반복 조건을 설정하는 반복문

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

- `int i = 0`: 반복을 실행하기 전 실행할 코드.
- `i < 10`: 반복을 유지할 조건. `while` 의 조건과 동일.
- `i++`: 한번의 반복이 끝날때 실행할 코드.

정해진 횟수만큼 반복하기 위해 많이 활용.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("로그인 정보를 입력하세요.");
    // 정보 입력하는 코드
}
System.out.println("5회 로그인에 실패하여 계정이 잠겼습니다.");
```

내부의 조건을 작성하지 않아도 되지만...

```java
for (;;) {
    System.out.println("이건 그냥 무한루프잖아");
}
```

### `foreach` (enhanced `for`)

배열과 같은 복수의 데이터를 담고있는 대상에 대하여 각 데이터를 하나씩 꺼내며 실행하는 반복문.

```java
String[] fruits = {"apple", "pear", "banana"};
for (String name : fruits) {
    System.out.println(name);
}
```

### 반복문 제어

반복문 실행 중 반복을 중단(`break`)하거나 반복문의 나머지 코드를 생략(`continue`)할 수 있다.

`break` - 반복문 실행 중 반복을 중단

```java
int price = 50;
int money = 200;
for (int i = 0; i < 5; i++) {
    money -= price;
    if (money - price < 0) {
        System.out.println("돈 다 썻어요");
        System.out.println(i);  // 3
        break;                  // 반복 중단
    }
}
```

`continue` - 반복문 실행 중 나머지 코드를 수행하지 않고 다음 반복으로 넘어가기

```java
for (int i = 0; i < 10; i++) {
    if (i % 2 != 0) {  // i가 2짝수가 아닐 경우,
        continue;      // 나머지 코드는 무시
    }
    System.out.println(i);
}
```

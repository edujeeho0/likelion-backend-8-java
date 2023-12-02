# 변수와 자료형

- [변수](#변수)
- [자료형](#자료형)
- [Scanner](#Scanner)
- [문자열 응용](#문자열-응용)
- [배열](#배열)

## 변수

프로그래밍 언어에서 데이터를 저장하기 위해 사용되는 데이터를 담는 상자의 역할.
이후 코드에서 값을 대신해서 사용 가능.
"변수에 데이터를 할당한다"고 말하며, 이미 값이 할당된 변수에도 값을 다시 할당할 수 있다.

```java
public class HelloJava {
    public static void main(String[] args) {
        // 변수 a에 100을 담는다.
        int a = 100;
        System.out.println(a);
        // 변수 b에 "Hello Variables!"를 담는다.
        String b = "Hello Variables!";
        System.out.println(b);
        
        // 값을 재활용 가능.
        int tteokBoKki = 3500;
        int sunDae = 4000;
        int raMyun = 3000;
        int kimBap = 2000;
        int kimBapTuna = 2500;
        System.out.println(tteokBoKki * 2 + sunDae);
        System.out.println(raMyun * 3);
        System.out.println(kimBap * 2 + kimBapTuna);
        
        // 한줄에 여러 변수도 선언 가능
        int month = 11, day = 20;
    }
}
```

변수 이름은 소문자를 사용하고, `camelCase`로 작성한다.
또한 [예약어](https://en.wikipedia.org/wiki/List_of_Java_keywords)를 사용하지 못한다.

```java
int 1stVar = 10;      // 문법적으로 올바르지 않다.
int second_var = 23;  // 문법적으로는 오류가 없지만, Naming Convention에 어긋난다.
int thirdVar = 42;
```

## 자료형

변수를 선언하면서, 이 변수가 어떤 형식의 데이터를 저장할 수 있는지를 정의.

- `int` - 정수형 데이터를 저장하는 자료형
- `String` - 문자열 데이터를 저장하는 자료형
- `double` - 실수형 데이터를 저장하는 자료형
- `char` - 글자 데이터를 저장하는 자료형
- `boolean` - 참/거짓 데이터를 저장하는 자료형
- `long` - 큰 정수형 데이터를 저장하는 자료형

### 정수

`int`, `long` 을 주로 활용하며 `byte`, `short` 등 더 작은 범위의 자료형도 존재.

| 자료형     | 최소                   | 최대                  |
|---------|----------------------|---------------------|
| `int`   | -2147483648          | 2147483647          |
| `long`  | -9223372036854775808 | 9223372036854775807 |
| `short` | -32768               | 32767               |
| `byte`  | -128                 | 127                 |

```java
int integer = 10;
// long의 경우 L을 뒤에 덧붙인다.
// l도 가능하지만 1과의 혼동 때문에 대문자를 주로 사용.
long bigInteger = 10000000000L;
short smallInteger = 10000;
byte reallySmallInteger = 127;
```

### 실수

`double`, `float`가 있으며, 그냥 작성하면 `double`로 간주된다.

| 자료형      | 최소            | 최대           | 유효숫자 |
|----------|---------------|--------------|------|
| `float`  | -3.4 * 10^38  | 3.4 * 10^38  | 7    |
| `double` | -1.7 * 10^308 | 1.7 * 10^308 | 16   |

```java
// long과 마찬가지로, float라는 의미의 F를 덧붙인다.
float floatPoint = 2.718281F;
double doublePoint = 3.14159265359;
```

### boolean

참 또는 거짓을 표현하기 위한 자료형

```java
boolean success = false;
boolean willSuccess = true;
```

### char - 문자

단일 문자를 표현하기 위한 자료형. 작은 따옴표 사용.

```java
char alphabet = 'a';
char charRepInt = '1';
```

### String - 문자열

문자(`char`)의 나열. 단어, 문장 등 여러 글자를 표현하기 위한 자료형.

```java
String word = "Hello";
String sentence = "this is a String variable.";
```

## `Scanner`

사용자 입력을 받는 가장 간편한 방법.

```java
Scanner scanner = new Scanner(System.in);
System.out.println(scanner.nextLine());
```

각 자료형에 맞는 데이터 입력을 받을 수 있다. 입력된 데이터 중 일부를 알맞은 자료형으로 변환한다.

```java
// nextInt()
int scanInt = scanner.nextInt();
// nextLong()
long scanLong = scanner.nextLong();
// nextFloat()
float scanFloat = scanner.nextFloat();
// nextDouble()
double scanDouble = scanner.nextDouble();
```

`boolean`은 대소문자 구분 없이 `true` 또는 `false`로 입력받는다.

```java
boolean scanBool = scanner.nextBoolean();
```

### `Scanner` 사용 시 유의점

`nextLine()`은 다음 개행문자까지 입력받지만, 다른 메서드는 필요한 만큼의 데이터만 입력받는다. 아래 코드를 실행하고

```java
int scanInt = scanner.nextInt();
String scanLine = scanner.nextLine();
```

다음과 같은 입력을 할 경우

```text
1 뒤쪽의 남는 입력
```

`scanLine`에 할당되는 데이터는 `" 뒤쪽의 남는 입력"`

## 문자열 응용

### Escape Sequence

`\ `를 사용하면 문자열 내부에 쉽게 표현하기 어려운 문자를 사용할 수 있다.

```java
// 문자열 내부에 " 표현하기
System.out.println("\"See you tommorow!\" he said.");
// char 데이터로 ' 표현하기
System.out.println('\'');
// 문자열 내부에서 \ 표현하기
System.out.println("\\");
```
다른 문자와 합쳐 문자로 표현하기 힘든 키보드의 자판도 표현 가능.
```java
// 개행, 탭, Carriage Return, Backspace
System.out.println("개행문자: \n 이 다음은 아래줄에 표현됩니다.");
System.out.println("탭키: \t다음 탭의 위치까지 옮긴 뒤 표현됩니다.");
System.out.println("Carriage Return: \r줄의 앞으로 옮깁니다.");
System.out.println("백스페이스: \b앞의 문자를 하나 지웁니다.");
```
```text
개행문자: 
 이 다음은 아래줄에 표현됩니다.
탭키: 	다음 탭의 위치까지 옮긴 뒤 표현됩니다.
줄의 앞으로 옮깁니다.
백스페이스:앞의 문자를 하나 지웁니다.
```

### String Formatting

문자열 내부의 일부분만 값으로 대체하는 기법.

```java
int dust = 10;
String status = "좋음";
// 미세먼지 농도: 10 (좋음)
System.out.println(String.format("미세먼지 농도: %d (%s)", dust, status));
```

`String.format()`과 포맷 코드를 활용하여 문자열 내에 대체할 곳을 지정한다.

| 코드   | 자료형                     |
|------|-------------------------|
| `%s` | 문자열(`String`)           |
| `%c` | 문자(`char`)              |
| `%d` | 정수(`int`)               |
| `%f` | 부동소수(`float`, `double`) |

## 배열

여러 데이터를 한곳에 저장하고 관리

```java
int[] scores = {85, 75, 90};
scores[1] = 80;

// 0부터 시작
System.out.println(scores[0]);
System.out.println(scores[1]);
System.out.println(scores[2]);
```

배열을 먼저 만들고 데이터 개별 할당 가능

```java
String[] names = new String[4];
names[0] = "alex";
System.out.println(names[0]);

// 크기를 변수로 전달할수도 있다.
int students = 10;
String[] names = new String[students];
int[] scores = new int[students];
```

배열의 크기는 `배열.length`로 알아낼 수 있다.

```java
int numOfStudents = studentNames.length;
System.out.println(numOfStudents);
```


# 메서드

정적 메서드를 활용, 클래스 내부 메서드는 클래스에서 다룬다.

<!-- TOC -->
* [메서드](#메서드)
  * [메서드 정의](#메서드-정의)
    * [매개변수](#매개변수)
    * [반환 (`return`)](#반환-return)
    * [메서드 호출](#메서드-호출)
  * [재귀함수](#재귀함수)
  * [Method Overloading](#method-overloading)
  * [가변인자, Varargs](#가변인자-varargs)
<!-- TOC -->

## 메서드 정의

특정 기능을 하는 코드를 한곳에 모아 실행할 수 있게 해주는 코드 묶음. 특정 코드를 매번 다시 작성하지 않고, 필요할때만 호출하여 사용.

기본 작성법: 

```java
<제어자> <반환 자료형> <메서드 이름>(<입력 자료형1> <매개변수1>, ...) {
    return <반환 값>;
}
```

예시:

```java
public class Main {
    public static int addTwo(int a, int b) {
        return a + b;
    }
}
```

- `int`: 이 메서드가 결과로 반환할 값이 어떤 자료형인지 작성.
- `addTwo`: 이 메서드의 이름. 이 메서드를 사용할 때 어떻게 호출 하는지.
- `(int a, int b)`: 이 메서드의 **매개변수**(parameter). 메서드를 호출한 코드가 전달한 값을 담는 변수.
- `return`: 최종적으로 메서드의 실행 결과가 어떤 값을 반환할지를 결정하는 키워드.

### 매개변수

괄호 안에, 메서드에 전달될 값들을 정의

```java
public static void parameters(int a, int b, int c) {
    System.out.println(a + b + c);
}
```

자료형은 대부분 사용 가능하다.

```java
public static void parameterArray(int[] intArray) {
    for (int item: intArray) {
        System.out.println(item);
    }
}
```

매개변수가 필요없다면 괄호를 비워둔다.

```java
public static void sayHello() {
    System.out.println("Hello!");
}
```

### 반환 (`return`)

메서드의 결과를 돌려주는 행위. `return` 키워드에 전달된 값이 호출한 코드로 전달된다.

```java
public static boolean isLeapYear1(int year) {
    boolean result = false;
    if (year % 4 == 0) {
        result = true;
        if (year % 100 == 0 && year % 400 != 0) {
            result = false;
        }
    }
    return result;
}
```

만일 메서드의 끝까지 가지 않고 반환값이 결정되면, 그 시점에 `return` 활용 가능.

```java
public static boolean isLeapYear2(int year) {
    if (year % 4 == 0) {
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        return true;
    }
    return false;
}
```

반환할 수 있는 값은 하나. 여러 데이터를 반환하고 싶다면 배열과 같은 자료형을 활용해야 한다.

값을 반환하지 않는 메서드라면, `void`를 반환형으로 설정. 그러면 메서드가 값을 반환하지 않으며, `return`을 사용할 필요도 없다.

```java
public static void printAllStrings(String[] strArr) {
    for (Strint str : strArr) {
        System.out.println(str);
    }
}
```

**반환과 출력은 다른 동작이다.**

```java
// 내부의 코드가 입력을 읽는다. 문자열을 반환한다.
String line = scanner.nextLine();
// 내부의 코드가 출력을 한다. 반환은 하지 않는다.
System.out.println(line);
```

### 메서드 호출

```java
public class Main {
    public static int addTwo(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result1 = addTwo(2, 3);
        System.out.println(result1);
    }
}
```

`main` 메서드의 첫줄에서 `addTwo` 메서드를 호출한다.
`2`와 `3`이 인자로 전달되, `a`와 `b`에 할당된다.

```java
public class Main {
    public static int addTwo(int a, int b) {
        return a + b;
    }

    public static int subTwo(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        // ...
        int result2 = subTwo(addTwo(4, 5), addTwo(2, 3));
        System.out.println(result2);
    }
}
```

1. `main` 메서드가 실행.
2. `addTwo(4, 5)` 가 먼저 호출. `9`가 반환되어 다시 `main`으로.
3. `addTwo(2, 3)` 가 이후 호출. `5`가 반환되며 다시 `main`으로.
4. `subTwo(9, 5)` 가 호출. `4`가 반환되며 다시 `main`으로.
5. `result2` 변수에 `4`가 할당.

## 재귀함수

어떤 문제를 해결하기 위해 자기 자신을 호출하는 메서드.
팩토리얼(`n!`)의 식은 `f(n) = n * f(n - 1)`으로 표현 가능.

```java
public static int factRec(int n) {
    // 0이나 1인 경우 1이다.
    if (n == 0 || n == 1) {
        return 1;
    } else {
        // n을 하나 줄여서 다시 호출한다.
        return n * factRec(n - 1);
    }
}
```

재귀함수는 성능상의 이점이 아닌, 코드 작성 및 가독성의 이점이 더 주효.

## Method Overloading

같은 이름의 메서드를 여러개 정의하여, 매개변수의 형태에 따라 다양한 기능을 구현할 수 있게 해주는 기능.

```java
public static int add(int a, int b) {
    return a + b;
}

public static long add(long a, long b) {
    return a + b;
}
```

두 메서드의 이름이 같다러도, 매개변수의 형태가 다르다면 호출 시점에 전달되는 데이터에 따라 호출할 메서드를 특정지을 수 있다.

```java
int a = 1, b = 2;
long c = 1, d = 2;

System.out.println(add(a, b));
System.out.println(add(c, d));
```

하지만 반환 타입만 다를 경우는 불가.
호출할때 어떤 메서드를 호출할지 특정지을 수 없다.

```java
// 불가
public static int add(int a, int b) {
    return a + b;
}

public static long add(int a, int b) {
    return (long) a + b;
}
```

메서드 오버로딩을 통해 기본값을 적용하는데 활용할 수 있다.

```java
// A: 시작점과 끝점을 받는 메서드.
public static int partSum(int[] arr, int s, int e) {
    int sum = 0;
    for (int i = s; i < e; i++) {
        sum += arr[i];
    }
    return sum;
}
// B: 시작점만 받는 메서드. 이때 끝점은 배열의 끝으로 설정해
// A를 호출한다(결국 e의 기본값은 arr.length).
public static int partSum(int[] arr, int s) {
    return partSum(arr, s, arr.length);
}
```

메서드 오버로딩의 대표적인 예시는 `println()`. 어떤 자료형을 넣든 다 실행이 된다.

```java
println() {}
println(boolean x) {}
println(char x) {}
println(char[] x) {}
println(double x) {}
println(float x) {}
println(int x) {}
println(long x) {}
println(java.lang.Object x) {}
println(java.lang.String x) {}
```

## 가변인자, Varargs

메서드가 받을 수 있는 인자의 갯수가 변동될 수 있을 때 활용가능.
매개변수 자료형에 `...`을 추가하여 사용.

```java
public static int varNumSum(int... numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    return sum;
}
```

호출은 여러개의 인자를 전달하거나, 배열을 전달할 수 있다.

```java
System.out.println(varIntSum(1, 2, 3, 4, 5));

int[] numbers = {1, 2, 3, 4};
System.out.println(varNumSum(numbers));
```

다른 인자를 함께 사용한다면, 가변인자를 마지막에 지정해준다.

```java
public static void repeatStrings(String line, int... counts) {
    for (int count : counts) {
        for (int i = 0; i < count; i++) {
            System.out.print(line);
        }
        System.out.println();
    }
}
```

메서드 오버로딩과 함께 활용할때는 주의할것.

```java
public static int varNumSum(int... numbers) {
    // ...
}

public static int varNumSum(int base, int...numbers){
    // ...
}

public static void main(String[] args) {
    // 오류
    System.out.println(varNumSum(1, 2, 3, 4, 5));
    
    // 정상
    System.out.println(varNumSum(1, new int[]{2, 3, 4, 5}));
    System.out.println(varNumSum(new int[]{1, 2, 3, 4, 5}));
}
```

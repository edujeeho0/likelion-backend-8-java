# 연산자

<!-- TOC -->
* [연산자](#연산자)
  * [산술 연산자](#산술-연산자)
    * [형변환](#형변환)
    * [문자열 덧샘](#문자열-덧샘)
    * [증감 연산자](#증감-연산자)
    * [할당 연산자](#할당-연산자)
  * [비교 연산자](#비교-연산자)
    * [논리 연산자](#논리-연산자)
  * [비트 연산자](#비트-연산자)
    * [AND 연산 `&`](#and-연산-)
    * [OR 연산 `|`](#or-연산-)
    * [XOR 연산 `^`](#xor-연산-)
    * [NOT 연산 `~`](#not-연산-)
    * [SHIFT 연산](#shift-연산)
  * [삼항 연산자](#삼항-연산자)
<!-- TOC -->

## 산술 연산자

사칙연산을 할때 사용하는 연산자.

| 연산자 | 설명                                       |
|-----|------------------------------------------|
| `+` | 왼쪽의 피연산자에서 오른쪽 피연산자를 더한 값을 반환한다.         |
| `-` | 왼쪽의 피연산자에서 오른쪽 피연산자를 뺀 값을 반환한다.          |
| `*` | 왼쪽의 피연산자에서 오른쪽 피연산자를 곱한 값을 반환한다.         |
| `/` | 왼쪽의 피연산자에서 오른쪽 피연산자를 나눈 값을 반환한다.         |
| `%` | 왼쪽의 피연산자에서 오른쪽 피연산자로 나눈 나머지를 반환한다. (모듈러) |

```java
int plus = 10 + 20;      // 30
int minus = 20 - 10;     // 10
int multiply = 20 * 10;  // 200
int divide = 20 / 10;    // 2
int modulo = 15 % 10;    // 5
```

괄호를 포함, 현실의 사칙연산 순서와 동일하게 계산한다.

```java
int result = (10 + 5 % 3) / 3 + 2 * 3;  // 괄호, 곰셈 나눗셈 모듈러, 그후 덧셈
```

나눗셈의 경우, `정수 / 정수`를 할 경우, 나머지나 소숫점이 나오지 않고 몫만 나온다.
받는 변수를 실수형으로 해도 `몫.0`의 형태가 된다.

```java
int notDivided = 21 / 10;
System.out.println(notDivided);  // 2
        
double doubleDivide = 21 / 10;
System.out.println(doubleDivide);  // 2.0
```

### 형변환

상황에 따라 자료형을 변경해야 할때, 형변환(Type Casting)을 할 수 있다.

```java
// <자료형> <변수명> = (<자료명>) <변환하려는 값>;
int integer = (int) 2.1;
```

대체로 더 작은 자료형에서 더 큰 자료형으로 변환할때는 자동으로 형변환된다.
묵시적 형변환.  
`byte` → `short` →  `int` → `long` → `float` → `double`

```java
byte byteVar = 1;
System.out.println(byteVar);
short shortVar = byteVar;
System.out.println(shortVar);
int intVar = shortVar;
System.out.println(intVar);
```

더 큰 자료형에서 더 작은 자료형으로 변환할때는 수동으로 변환한다. 이때 데이터 손실이 발생할 수 있다.
명시적 형변환.

```java
double doubleVar = 10.24;
int castedDouble = (int) doubleVar;
System.out.println(castedDouble);  // 10

int dataLost = (int) 4294967296L;
System.out.println(dataLost);  // 0
```

정수의 나눗셈을 할때 실수 결과가 필요하면 먼저 형변환을 진행할 수 있다.

```java
double doubleDivide = (double) 21 / 10;
System.out.println(doubleDivide);
```

`char`도 `int`를 비롯한 자료형과 연산이 가능.

```java
int intPlusChar = 10;
char char1 = 65;
char char2 = 10;
System.out.println(intPlusChar + char1);           // 75
System.out.println((char) (intPlusChar + char1));  // K
System.out.println(char1 + char2);                 // 75
```

### 문자열 덧샘

문자열을 더할때는 문자열이 연결(Concatenation)된다.

```java
int intPlusChar = 10;
char char1 = 65;
char char2 = 10;
System.out.println(intPlusChar + char1);           // 75
System.out.println((char) (intPlusChar + char1));  // K
System.out.println(char1 + char2);                 // 75
```

다른 자료형이 있을경우 문자열로 해석된다. (형변환과는 조금 다름)

```java
int date = 4;
// Today is 4th of July
System.out.println("Today is " + date + "th of July");
```

### 증감 연산자

변수의 값을 하나씩 증가하거나 감소시킨다. 연산에 필요한 피연산자가 하나만 있으면 되는 단항 연산자.

| 연산자 | 설명                |
|-----|-------------------|
| `++`  | 피연산자의 값을 1 증가시킨다. |
| `--`  | 피연산자의 값을 1 감소시킨다. |

```java
int count = 0;
count++;
System.out.println(count);  // 1
count++;
System.out.println(count);  // 2
count--;
System.out.println(count);  // 1
count = 10;
System.out.println(++count);  // 출력: 11 (출력 전에 1 증가, 값: 11)
System.out.println(count++);  // 출력: 11 (출력 후에 1 증가, 값: 12)
System.out.println(--count);  // 출력: 11 (출력 전에 1 감소, 값: 11)
System.out.println(count--);  // 출력: 11 (출력 후에 1 감소, 값: 10)
```

### 할당 연산자

변수의 값을 활용해 연산과 할당을 동시에 진행한다.

| 연산자  | 설명                                          | 사용       | 비교          |
|------|---------------------------------------------|----------|-------------|
| `=`  | 왼쪽의 피연산자에 오른쪽 피연산자를 할당한다.                   |          |             |
| `+=` | 왼쪽의 피연산자에서 오른쪽 피연산자를 더한 값을 왼쪽 피연산자에 할당한다.   | a += 10; | a = a + 10; |
| `-=` | 왼쪽의 피연산자에서 오른쪽 피연산자를 뺀 값을 왼쪽 피연산자에 할당한다.    | a -= 10; | a = a - 10; |
| `*=` | 왼쪽의 피연산자에서 오른쪽 피연산자를 곱한 값을 왼쪽 피연산자에 할당한다.   | a *= 10; | a = a * 10; |
| `/=` | 왼쪽의 피연산자에서 오른쪽 피연산자를 나눈 값을 왼쪽 피연산자에 할당한다.   | a /= 10; | a = a / 10; |
| `%=` | 왼쪽의 피연산자에서 오른쪽 피연산자로 나눈 나머지를 왼쪽 피연산자에 할당한다. | a %= 10; | a = a % 10; |

```java
int addTo = 1;   // 1
addTo += 10;     // 11
addTo *= addTo;  // 121
```

## 비교 연산자

관계 연산자, 두개의 값의 대소를 비교하여 `boolean`을 반환한다.

| 연산자  | 설명                                             |
|------|------------------------------------------------|
| `==` | 왼쪽의 피연산자와 오른쪽 피연산자가 같으면 참, 다르면 거짓을 반환한다.       |
| `!=` | 왼쪽의 피연산자와 오른쪽 피연산자가 다르면 참, 같으면 거짓을 반환한다.       |
| `>`  | 왼쪽의 피연산자가 오른쪽 피연산자 보다 크면 참, 작거나 같으면 거짓을 반환한다.  |
| `>=` | 왼쪽의 피연산자가 오른쪽 피연산자 보다 크거나 같으면 참, 작으면 거짓을 반환한다. |
| `<`  | 왼쪽의 피연산자가 오른쪽 피연산자 보다 작으면 참, 크거나 같으면 거짓을 반환한다. |
| `<=` | 왼쪽의 피연산자가 오른쪽 피연산자 보다 작거나 같으면 참, 크면 거짓을 반환한다.  |


```java
int small1 = 10;
int small2 = 10;
int big = 21;

System.out.println(small1 == small2);  // true
System.out.println(small1 == big);     // false
System.out.println(small1 != small2);  // false
System.out.println(small1 != big);     // true
System.out.println(small1 > big);      // false
System.out.println(small1 >= big);     // false
System.out.println(small1 >= small2);  // true
System.out.println(small1 < big);      // true
System.out.println(small1 <= big);     // true
System.out.println(small1 <= small2);  // true
```

### 논리 연산자

참 거짓 데이터를 조합하여, `그리고`, `또는`, `부정` 등을 표현하기 위한 연산자.

| 연산자    | 설명                                              |
|--------|-------------------------------------------------|
| `&&`   | 왼쪽의 피연산자와 오른쪽 피연산자가 모두 참일 때 참, 아니면 거짓을 반환한다.    |
| `\|\|` | 왼쪽의 피연산자와 오른쪽 피연산자 중 하나라도 참일 때 참, 아니면 거짓을 반환한다. |
| `!`    | 피연산자가 참이면, 거짓, 거짓이면 참을 반환한다. (부정)               |

```java
int temperature = 38;
int age = 20;

boolean notSick = temperature <= 37;    // 체온이 37도 이하
boolean isOfAge = age >= 20;            // 나이가 20살 이상
boolean canEnter = notSick && isOfAge;  // 입장 가능한가?
System.out.println(canEnter);

boolean isSunday = true;                  // 일요일인가?
boolean isHoliday = false;                // 공휴일인가?
boolean canRest = isSunday || isHoliday;  // 오늘은 쉬는날인가?
System.out.println(canRest);
```

연산 순서는 `!` → `&&` → `||`

```java
boolean a = true;
boolean b = false;
boolean c = false;

System.out.println(a && b || !c);      // true
System.out.println(a && b || a && c);  // false
System.out.println(c || b && a || c);  // false
```

## 비트 연산자

두 숫자의 비트를 비교, 각 자리가 `1`인지 `0`인지를 바탕으로 새로운 숫자를 만드는 연산자.

| 연산자   | 비트 연산                                                       |
|-------|-------------------------------------------------------------|
| `&`   | 두 수 각 자리의 비트가 둘다 1이면 결과 자리의 비트도 1 (AND 연산)                  |
| `\|`  | 두 수 각 자리의 비트가 둘중 하나라도 1이면 결과 자리의 비트도 1 (OR 연산)              |
| `^`   | 두 수 각 자리의 비트가 서로 다르면 결과 자리의 비트가 1 (XOR 연산)                  |
| `~`   | 각 자리의 비트를 1이면 0으로, 0이면 1로 (NOT 연산)                          |
| `<<`  | 오른쪽 피연산자의 수만큼 비트를 왼쪽으로 이동 (LEFT SHIFT 연산)                   |
| `>>`  | 오른쪽 피연산자의 수만큼 비트를 오른쪽으로 이동, 부호가 변하지 않는다. (RIGHT SHIFT 연산)   |
| `>>>` | 오른쪽 피연산자의 수만큼 비트를 오른쪽으로 이동, 새로운 비트는 0이 된다. (RIGHT SHIFT 연산) |

### AND 연산 `&`

두 숫자 각 자리의 비트가 모두 `1`이면 결과 자리도 `1`, 아니면 `0`

```java
/*
    1011 = 11
AND 0101 = 5
--------
    0001 = 1
*/
System.out.println(11 & 5);  // 1
```

### OR 연산 `|`

두 숫자 각 자리의 비트 중 하나라도 `1`이면 결과 자리도 `1`, 아니면 `0`

```java
/*
    1011 = 11
OR  0101 = 5
--------
    1111 = 15
*/
System.out.println(11 | 5);  // 15
```

### XOR 연산 `^`

두 숫자 각 자리의 비트가 다르면 `1`, 같으면 `0`

```java
/*
    1011 = 11
XOR 0101 = 5
--------
    1110 = 14
*/
System.out.println(11 ^ 5);  // 14
```

### NOT 연산 `~`

각 자리의 비트를 `1`은 `0`으로 `0`은 `1`로

```java
/*
NOT 0000 1011 = 1111 0100 = -12
NOT 0000 0101 = 1111 1010 = -6
*/
System.out.println(~11);  // -12
System.out.println(~5);   // -6
```

### SHIFT 연산

한 숫자의 비트를 주어진 수만큼 이동하는 연산

```java
/*
0000 1011 SHIFT LEFT  2 = 0010 1100 = 44
0000 1011 SHIFT RIGHT 2 = 0000 0010 = 2
*/
System.out.println(11 << 2);  // 44
System.out.println(11 >> 2);  // 2
```

SHIFT RIGHT의 경우 최고자리의 비트를 원래대로 유지하거나(`>>`), `0`으로 채우는(`>>>`) 두가지가 있음.

```java
/*
>> 와 >>> 의 차이 예시
1111 1010 >> 2  = 1111 1110
1111 1010 >>> 2 = 0011 1110 
실제 연산시에는 더 많은 비트를 사용합니다.
*/
System.out.println(-6 >> 2);   // -2
System.out.println(-6 >>> 2);  // 1073741822
```

## 삼항 연산자

어떤 특정 조건이 참인지 거짓인지에 따라 결과를 달리할 수 있는 연산자.

```java
int temperature = 37;
String message = temperature < 38 ? "OK" : "Feverish";
```

남용하면 가독성이 나빠질 수 있다.

```java
// x가 양수일때 y가 양수면 1, 아니면 2
// x가 음수일때 y가 양수면 3, 아니면 4
int result = (x > 0) ? ((y > 0) ? 1 : 2) : ((y > 0) ? 3 : 4);
```

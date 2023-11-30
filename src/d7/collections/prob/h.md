## Collections Framework 연습문제

### H1

엔터로 구분된 입력이 임의의 횟수만큼 이뤄진다.
`q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
여태까지 입력한 내용중 **정수**만을 선별하여,
`<첫번째 정수> + <두번째 정수> + <세번째 정수> = <총합>`
의 형태로 출력하시오.
힌트: `Integer.parseInt` 메서드는 정수로 표현
불가능한 문자열에 대해 `NumberFormatException`을 발생시킨다.

예시 입출력
입력1:
```text
1
2
3
4
q
```
출력1:
```text
1 + 2 + 3 + 4 = 10
```
---
입력2:
```text
1,
정수 아님
2
1.01
q
```
출력2:
```text
2 = 2
```


### H2

엔터로 구분된 입력이 임의의 횟수만큼 이뤄진다.
`q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
여태까지 입력한 정수가 몇가지가 되는지와 그 총합을 출력하시오.

힌트: `Integer.parseInt` 메서드는 정수로 표현 불가능한 문자열에 대해 `NumberFormatException`을 발생시킨다.

예시 입출력
입력1:
```text
1
2
3
4
q
```
출력1:
```text
4
10
```
---
입력2:
```text
3
2
2
3
q
```
출력2:
```text
2
5
```
---
입력3:
```text
1,
정수 아님
2
1.01
q
```
출력3:
```text
1
2
```

### H3
엔터로 구분된 누군가의 이름 입력이 임의의 횟수만큼 이뤄진다.
`q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
여태까지 입력된 이름을 중복없이 알파벳 순서데로 출력하시오.

힌트: `Collections.sort`를 이용하면 리스트를 정렬할 수 있다.

예시 입출력
입력1:
```text
Chad
Dave
Alex
Brad
q
```
출력1:
```text
Alex
Brad
Chad
Dave
```
---
입력2:
```text
Chad
Dave
Alex
Brad
Alex
Dave
q
```
출력2:
```text
Alex
Brad
Chad
Dave
```


### H4
여러 사람의 전공이 `전공 이름` 형태로 입력된다.
`"q"`가 입력되었을 때,
각 전공별로 누가 있는지를 출력하시오.
단, 전공 순서와 사람 순서는 상관 없다.

예시 입출력
입력1:
```text
CSE Chad
EEE Dave
EEE Alex
BA Eric
BA Fred
CSE Brad
q
```
출력1:
```text
CSE Chad Brad
EEE Alex Brad
BA Eric Fred
```


### H5

어떤 가게의 메뉴 `<메뉴명> <가격>`형태로 계속 입력되다가,
`"order"`가 입력되면 그 뒤에 주문이 `<메뉴명> <갯수>`형태로 입력되기 시작하며,
`"done"`가 입력되면 주문이 완료된다.
사용자의 주문을 받고 총액을 출력하시오.

예시 입출력:
입력1
```text
Americano 1500
Cappuccino 2000
Latte 2500
Mocha 3000
order
Latte 2
Americano 2
Cappuccino 1
done
```
출력1:
```text
10000
```

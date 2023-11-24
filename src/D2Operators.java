public class D2Operators {
    public static void main(String[] args) {
        int plus = 10 + 20;
        int minus = 20 - 10;
        int multiply = 20 * 10;
        int divide = 20 / 10;
        int modulo = 15 % 10;
        System.out.println(plus);      // 30
        System.out.println(minus);     // 10
        System.out.println(multiply);  // 200
        System.out.println(divide);    // 2
        System.out.println(modulo);    // 5

        // 사칙연산의 우선순위
        int result = 10 + 5 * 3;
        System.out.println(result);    // 25
        // 괄호가 최우선
        result = (10 + 5) * 3;
        System.out.println(result);    // 45
        // %의 우선순위는?
        result = (10 + 5 % 3) / 3 + 2 * 3;  // 10
        System.out.println(result);

        System.out.println(21 / 10);  // 2

        // 1. 데이터를 받는 애를 int가 아니라 double로 해보자.
        double doubleDivide = 21 / 10;
        System.out.println(doubleDivide);

        // 2. 나누기 전에 실수로 만들어 주자.
        // 피연산자 중 하나라도 double이면 결과도 double
        doubleDivide = 21 / 10.0;
        System.out.println(doubleDivide);

        // 피연산자 둘다 정수 변수면?
        // 형변환(Type Casting)
        int intResult = (int) 2.1;

        System.out.println(intResult);

        // 선 변환을 통한 나누기 연산
        int left = 21;
        int right = 10;
        double castedResult = (double) left / right;
        System.out.println(castedResult);

        // 명시적 형변환 데이터 손실
        long bigInt = 4294967296L;
        System.out.println((int) bigInt);

        // char 형 변환
        int asciiA = 65;
        System.out.println((char) asciiA);
        System.out.println((char) (asciiA + 10));

        // String 덧셈
        // String Concatenation
        System.out.println("여기에 10을 입력하시오: " + 10);
        System.out.println(10 + " + " + 10 + " = " + 20);
        String formula = 10 + " + " + 10 + " = " + 20;

        char largeA = 'A';
        char ten = 10;
        System.out.println((char) (largeA + ten));

        int count = 0;
        count++;
        System.out.println("현재 횟수: " + count);
        count++;
        System.out.println("현재 횟수: " + count);
        count--;
        System.out.println("현재 횟수: " + count);
        ++count;
        --count;
        System.out.println("최종: " + count);

        count = 10;
        System.out.println(++count);  // 11 (출력 전에 1 증가, 값 11)
        System.out.println(count++);  // 11 (출력 후에 1 증가, 값 12)
        System.out.println(--count);  // 11 (출력 전에 1 감소, 값 11)
        System.out.println(count--);  // 11 (출력 후에 1 감소, 값 10)

        int addTo = 1;
        addTo += 10;     // 11
        addTo *= addTo;  // 121

        addTo /= 12;  // addTo = addTo / 12;
        addTo %= 10;  // addTo = addTo % 10;
        addTo -= 20;  // addTo = addTo - 20;
        addTo *= -1;  // addTo = addTo * -1;

        System.out.println(addTo);

        // 비교 연산자
        int small1 = 10;
        int small2 = 10;
        int big = 21;
        double bigD = 21.0;
        System.out.println(small1 == small2);
        System.out.println(big == small1);
        System.out.println(big == bigD);
        System.out.println(small1 > small2);
        System.out.println(small1 >= small2);
        System.out.println(small1 != small2);
        System.out.println(small1 <= small2);
        System.out.println(small2 < bigD);

        int temperature = 38;
        int age = 20;

        // 체온은 37 이하
        boolean notSick = temperature <= 37;
        // 나이는 20 이상
        boolean isOfAge = age >= 20;
        // 입장 가능한가?
        boolean canEnter = notSick && isOfAge;
        System.out.println(canEnter);

        // 일요일 이거나 공휴일이다.
        // 일요일 이다.
        boolean sunday = false;
        // 공휴일 이다.
        boolean holiday = false;
        // 쉬는날이다.
        boolean canRest = sunday || holiday;
        System.out.println(canRest);

        // 아니다.
        int number = 10;
        boolean isNegative = number < 0;
        boolean isNotNegative = !isNegative;  // !=
        System.out.println(isNegative);
        System.out.println(isNotNegative);


        // 비트 연산자
        // 11 = 0000 1011
        //  5 = 0000 0101
        // 비트연산 AND (&)
        System.out.println(11 & 5);
        // 비트연산 OR  (|) (SHIFT + \)
        System.out.println(11 | 5);
        // 비트연산 XOR (^)
        System.out.println(11 ^ 5);
        // 비트연산 NOT (~)
        System.out.println(~11);
        System.out.println(~5);
        // SHIFT 연산
        System.out.println(12 << 2);
        System.out.println(12 >> 1);
        System.out.println(-12 >> 1);
        System.out.println(-12 >>> 1);
        // int a가 짝수일 때 a & 1은 0
        // << == * 2, >> == / 2
        // ~a = -a - 1

        // 미세먼지 수치
        int dust = 37;
        // 80 이하면 "좋음", 아니면 "나쁨"
        String message = dust <= 80 ? "좋음" : "나쁨";
        System.out.println(String.format("미세먼지 수치: %d, (%s)", dust, message));
    }
}









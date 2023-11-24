import java.util.Scanner;

public class D1VarAndTypes {
    public static void main(String[] args) {
        int a = 100;
        System.out.println(a);
        // b라는 이름의 상자에 "Hello Variables!"라는 데이터를 넣어준다.
        String b = "Hello Variables!";
        // b에 들어있는게 뭔지 확인한다.
        System.out.println(b);

        // a를 한번만 쓸 수 있는건 아니고 계속 확인 가능
        System.out.println(a);
        // a의 값을 변경하고 싶다면 다시 = 을 사용
        // 이때는 자료형 생략
        a = 50;
        System.out.println(a);
        // 단 맞는 자료형의 데이터만 넣어주어야 한다.
        // a = "이거 될까요?";  // error
        // 이름은 중복될 수 없음
        // String a = "이거는요?";  // error

        int americano = 1500;
        int cappuccino = 2500;
        int caffeLatte = 3000;
        int caffeMocha = 4000;
        // 아메리카도 5잔 가격 출력
        System.out.println(americano * 5);
        // 카푸치노 3잔 + 카페라떼 2잔 가격 출력
        System.out.println(cappuccino * 3 + caffeLatte * 2);
        // 카페모카 1잔 + 아메리카노 3잔 가격 출력
        System.out.println(caffeMocha + americano * 3);

        // 변수 선언
        int frappe;
        // 여기서 뭔가 한다...원가 계산이라든지
        frappe = 10000;

        // 한줄에 여러 변수 선언 및 할당
        int hotTea = 1000, iceTea = 1500;
        b = "다른 텍스트?";


        // 자료형들
        // 정수형 자료형
        int integer = 10;
        integer = -10;
        integer = 0;
        // integer = 12.05;  // error
        // -2147483648 ~ 2147483647
        // integer = 100000000000;
        long longInteger = 100000000000L;
        // 잘 안씀
        short smallInteger = 10000;
        byte reallySmallInteger = 127;

        // 실수형 자료형
        float floatPoint = 2.718F;
        // 거의 double 만 쓴다.
        double doublePoint = 3.14159265359;
        // 진짜 긴 소수는?
        double longPi = 3.14159265358979323846;
        System.out.println(longPi);

        // 불린형 자료형 (참 또는 거짓)
        boolean success = false;
        boolean willSuccess = true;
        success = true;
        System.out.println(success);

        // 문자와 문자열
        char alphabet = 'a';
        char digit = '1';
        // char isString = "1";  // 한글자라고 해도 큰따옴표는 문자가 아닌 문자열

        String word = "Hello";
        String sentence = "this is a String Variable";
/*
        // Scanner로 입력받기
        Scanner scanner = new Scanner(System.in);
        String scannedLine = scanner.nextLine();
        System.out.println(scannedLine);

        // scanner.next<자료형>();
        int scannedInt = scanner.nextInt();
        long scannedLong = scanner.nextLong();
        System.out.println(scannedInt);
        System.out.println(scannedLong);

        float scannedFloat = scanner.nextFloat();
        double scannedDouble = scanner.nextDouble();
        System.out.println(scannedFloat);
        System.out.println(scannedDouble);

        boolean scannedBool = scanner.nextBoolean();
        System.out.println(scannedBool);

        // nextLine() 유의점
        scanner.nextInt();
        scannedLine = scanner.nextLine();
        System.out.println(scannedLine);
*/
        // "내일 봐~" 하고 말하였다.
        String quote = "\"내일 봐\" 하고 말하였다.";
        System.out.println(quote);

        char quotation = '\'';
        System.out.println(quotation);

        String doubleBack = "\\ is backslash";
        System.out.println(doubleBack);

        // 엔터키(개행문자), 백스페이스, 탭키
        System.out.println("개행문자: \n이 다음은 다음 줄에 표현됩니다.");
        System.out.println("name\tscore");
        System.out.println("Alex\t3.5");
        System.out.println("Thomas\t4.0");


        // 231117
        String message = "미세먼지 농도: 10 (좋음)";
        // 231118
        message = "미세먼지 농도: 11 (좋음)";

        // 문자열 포맷팅 - String Formatting
        int dust = 35;
        String status = "나쁨";
        String msgTemplate = "미세먼지 농도: %d (%s)";
        // System.out.println(String.format("미세먼지 농도: %d (%s)", dust, status));
        System.out.println(String.format(msgTemplate, dust, status));

        // 배열
        int[] scores = {85, 75, 90};

        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);

        scores[0] = 90;
        scores[1] = 80;
        scores[2] = 95;
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);

        int studentCount = 10;
        String[] names = new String[studentCount];
        scores = new int[studentCount];

        // 어떤 식으로든 점수를 입력 받고,
        scores[0] = 80;
        scores[1] = 90;

        // ...

        Scanner scanner = new Scanner(System.in);
        scores = new int[3];
        // 정수를 세개를 각각 scores
        scores[0] = scanner.nextInt();
        scores[1] = scanner.nextInt();
        scores[2] = scanner.nextInt();
    }
}












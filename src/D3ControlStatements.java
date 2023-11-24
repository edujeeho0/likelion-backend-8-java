import java.util.Scanner;

public class D3ControlStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 나이를 입력받고, 나이가 20 미만일때 입장불가 출력
        int age = 20;
        if (age < 20) {
            System.out.println("입장불가");
            System.out.println(String.format("%d년 뒤에 오세요", 20 - age));
        }

        int multiple = 7;
        // multiple이 2의 배수면, 2의 배수 출력
        if (multiple % 2 == 0) {
            System.out.println("2의 배수");
        }
        // multiple이 5의 배수면, 5의 배수 출력
        if (multiple % 5 == 0) {
            System.out.println("5의 배수");
        }
        // multiple이 10의 배수면, 10의 배수 출력
        if (multiple % 10 == 0) {
            System.out.println("10의 배수");
        }
        // 몇년인지 받는다.
        int year = 2023;
        if (year % 4 == 0) {
            scanner.nextLine();
            String message = scanner.nextLine();
            if (year % 100 != 0) {
                System.out.println("윤년이다");
            }
            if (year % 400 == 0) {
                System.out.println("윤년이다");
            }
        }

        // 2의 배수면 짝수 아니면 홀수
        int number = 5;
        if (number % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }

        /*
        어떤 학생의 시험점수가 입력 되었을 때,
        80점을 넘으면 "Good Job"
        못넘으면 "Too Bad"
        * */
        int score = 80;
        if (score > 80) {
            System.out.println("Good Job");
        } else {
            System.out.println("Too Bad");
        }

        int result;
        int x = 10;
        int y = -2;
        if (x > 0) {
            if (y > 0) {
                result = 1;
            } else {
                result = 2;
            }
        } else {
            if (y > 0) {
                result = 3;
            } else {
                result = 4;
            }
        }
        System.out.println(result);

        // 0 ~ 100
        score = 101;
        if (0 <= score && score <= 100) {
            if (score > 80) {
                System.out.println("Good Job");
            } else {
                System.out.println("Too Bad");
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        // 0 ~ 30: 좋음
        // 31 ~ 80: 보통
        // 80 ~ 150: 나쁨
        // 151 ~ : 매우 나쁨
        int dust = 155;
        if (dust <= 30) {
            System.out.println("좋음");
        } else if (dust <= 80) {  // dust > 30은 무조건 성립
            System.out.println("보통");
        } else if (dust <= 150) { // dust > 150은 무조건 성립
            System.out.println("나쁨");
        } else {
            System.out.println("매우 나쁨");
        }

        // 하나의 if라도 맞으면 나머지는 조건 확인도 안한다.
        int zero = 0;
        if (zero == 0) {
            System.out.println("is zero");
        }
        else if (10 % zero == 0) {
            System.out.println("is factor");
        }
        else {
            System.out.println("not factor");
        }

        String input = "scanner.nextLine()";
        // (확인하고 싶은 값)
        switch (input) {
            case "w":  // input == "w"
                System.out.println("up");
                break;
            case "a":  // input == "a"
                System.out.println("left");
                break;
            case "s":  // input == "s"
                System.out.println("down");
                break;
            case "d":  // input == "d"
                System.out.println("right");
                break;
            // 기본동작, 필수 아님
            default:
                System.out.println("invalid");
                break;
        }

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

        // while
        // 대출금 천만원
        int loan = 1716;
        int months = 0;
        // 대출금 남았니?
        while (loan > 0) {
            loan -= 50;
            loan *= 1.03;
            months++;
            System.out.println("남은 대출액: " + loan);
        }
        System.out.println("대출 상환 완료! 총 걸린 개월수: " + months);

        int[] numbers = {2, 3, 5, 6, 19, 23};
        int idx = 0;
        // 총합 및 평균 구하기
        int sum = 0;
        while (idx < numbers.length) {
            System.out.println(numbers[idx]);
            sum += numbers[idx];
            idx++;
        }
        System.out.println(sum);
        System.out.println((double) sum / numbers.length);

        // for
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // 총합, 최대, 평균
        sum = 0;
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
            max = numbers[i] > max ? numbers[i] : max;
        }
        System.out.println(sum);
        System.out.println(max);
        System.out.println((double) sum / numbers.length);

        /*
        *
        **
        ***
        ****
        *****
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

//        for(;;) {
//            System.out.println("이건 그냥 무한루프입니다");
//        }

        // foreach
        String[] fruits = {"apple", "pear", "banana"};
        for (String name : fruits) {
            System.out.println(name);
        }

        // 같은 기능을 하는 for문은
        for (int i = 0; i < fruits.length; i++) {
            String name = fruits[i];
            System.out.println(name);
        }

        // 반복문 제어
        int wallet = 20000;
        int price = 5000;
        while (true) {
            wallet -= price;
            if (wallet <= 0) {
                System.out.println("돈 다 써서 더 못먹음ㅠㅠ");
                // 그만먹자.
                break;
            }
            System.out.println(String.format("1인분 먹고 %d 남음", wallet));
        }

        // numbers 내부에 19가 어디있는지
        // 있다면 그 위치를, 없다면 -1을 출력하도록
        numbers = new int[]{1, 3, 4, 11, 19, 21, 23};
        int target = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 19) {
                target = i;
                // 발견 즉시 반복 종료
                break;
            }
        }
        System.out.println(target);

        // continue
        // 0 ~ 9 사이의 짝수만 출력하고 싶다.
        System.out.println("continue");
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }

        // 백신을 맞지 않은 사람만 세기
//        boolean[] vaccinated = {true, false, false, false, true, true, false, false, false};
        boolean[] vaccinated = {true, false, false, false, false, false, false, true, true};
        int groupCount = 0;
        for (boolean vaccine : vaccinated) {
            if (vaccine) {
                System.out.println("백신 맞으면 세지 않아요");
                continue;
            }
            groupCount++;
            // 일정 인원 이상이면 입장불가
            if (groupCount > 5) {
                System.out.println("입장이 불가합니다...");
                break;
            }
        }

    }
}







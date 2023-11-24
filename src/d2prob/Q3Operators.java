package d2prob;

import java.util.Scanner;

/*
Scanner 이외의 변수를 한개만 선언하여
정수를 총 5개 입력받아,
첫번째 입력된 숫자에, 이후에 입력된 숫자를 순서대로
더하고 빼고 곱하고 몫을 구하여 출력하여라.
 */
public class Q3Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        num += scanner.nextInt();
        num -= scanner.nextInt();
        num *= scanner.nextInt();
        num /= scanner.nextInt();
        System.out.println(num);
    }
}









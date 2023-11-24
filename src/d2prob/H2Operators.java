package d2prob;

import java.util.Scanner;

/*
어떤 수 A와 B가 입력된다.
A를 B로 나눈 몫과 나머지를, "A = 몫 * B + 나머지"의 형태로 출력하여라.
예) A = 10, B = 3가 입력될때,
A = 3 * B + 1
 */
public class H2Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(String.format("A = %d * B + %d", a / b, a % b));
    }
}

package d2prob;

import java.util.Scanner;

/*
두 정수 A와 B가 입력될 때,
A가 B로 나누어 떨어지는지를 true 또는 false로 출력하여라.
 */
public class H4Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a % b == 0);
    }
}

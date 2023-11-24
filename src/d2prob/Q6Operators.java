package d2prob;

import java.util.Scanner;

/*
세개의 양의 정수 A, B, C를 입력받아서,
A가 B와 C의 공배수인지를 true 또는 false로 출력하여라.
 */
public class Q6Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean isCommonMultiple = a % b == 0 && a % c == 0;
        System.out.println(isCommonMultiple);
    }
}

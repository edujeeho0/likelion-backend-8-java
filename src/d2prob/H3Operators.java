package d2prob;

import java.util.Scanner;

/*
ASCII 코드로 'A'는 65이다.
1 ~ 26 사이의 숫자 n이 입력될 때, n번째 알파벳을 대문자로 출력하여라.
 */
public class H3Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 'A' == 65 이고, n == 1 일때 출력이 'A'
        System.out.println((char) (64 + n));
    }
}

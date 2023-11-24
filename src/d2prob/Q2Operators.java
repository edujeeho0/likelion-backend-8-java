package d2prob;

import java.util.Scanner;

/*
현재 오전 7시이다.
정수 n을 입력받아서,
n 시간 후 12시까지 표기된 시계에서
시침이 어떤 숫자 위에 있는지 구하시오. (단, 12시는 0으로 표기한다)
0 <= n <= 127;
 */
public class Q2Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int current = 7;
        int n = scanner.nextInt();
        // 현재 시각은 current + n
        System.out.println((current + n) % 12);
        System.out.println(current % 12 + n % 12);
    }
}

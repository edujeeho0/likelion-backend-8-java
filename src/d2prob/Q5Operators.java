package d2prob;

import java.util.Scanner;

/*
기온이 20도 초과, 30도 미만일 때 나들이 가기가 좋다.
기온을 (정수로) 입력받아 오늘 나들이를 갈지 말지를 true 또는 false로 나타내시오.
 */
public class Q5Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        boolean goOut = temp > 20 && temp < 30;
        System.out.println(goOut);
    }
}

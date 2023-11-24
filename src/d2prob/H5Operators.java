package d2prob;

import java.util.Scanner;

/*
Scanner 이외의 변수를 한개만 선언하여
정수 A를 입력받아,
A^2, A^4, A^8의 1의 자리를 순서대로 한줄씩 출력하시오.
 */
public class H5Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        base *= base;
        base %= 10;
        System.out.println(base);
        base *= base;
        base %= 10;
        System.out.println(base);
        base *= base;
        base %= 10;
        System.out.println(base);
    }
}

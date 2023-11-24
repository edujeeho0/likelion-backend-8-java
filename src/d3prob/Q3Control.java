package d3prob;

import java.util.Scanner;

/*
정수 n과 n개의 정수가 한줄씩 순서대로 입력된다.
n개의 정수의 총합, 평균을 출력하여라.
 */
public class Q3Control {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        // 몇개의 정수가 입력될지 n에 저장되어 있다.
        // 즉 n번 반복해서 입력을 받으면 된다.
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
        System.out.println((double) sum / n);
    }
}

package d1prob;

import java.util.Scanner;

/*
시간과 오전 오후를 입력받고, 11 오전 -> nextInt() -> nextLine()
오전 XX시
의 형식으로 출력하는 코드를 작성하시오.
 */
public class Q4VarAndTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        // nextLine: 남은 줄 전체
        // next: 다음 단어
        String amPm = scanner.nextLine();
        System.out.println(String.format("%s %d시", amPm, time));
    }
}

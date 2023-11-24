package d1prob;

import java.util.Scanner;

/*
사용자에게 입력을 받고,
동일한 내용을 세번 출력하는 코드를 작성하시오.
 */
public class Q1VarAndTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 사용자의 입력을 변수로 저장한다.
        String inputLine = scanner.nextLine();
        // 동일한 변수를 3번 출력한다.
        System.out.println(inputLine);
        System.out.println(inputLine);
        System.out.println(inputLine);
    }
}

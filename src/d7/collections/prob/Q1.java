package d7.collections.prob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Scanner와 List
// 엔터로 구분된 입력이 임의의 횟수만큼 이뤄진다.
// `q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
// 여태까지 입력했던 데이터를 순서데로 출력하시오.
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            // `q`가 입력시 반복(입력) 종료
            if ("q".equals(input)) break;
            inputList.add(input);
        }
        // fori
        for (int i = 0; i < inputList.size(); i++) {
            System.out.println(inputList.get(i));
        }

        // foreach
        for (String input : inputList) {
            System.out.println(input);
        }
    }
}

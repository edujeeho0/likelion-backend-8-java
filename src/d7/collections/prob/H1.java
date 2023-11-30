package d7.collections.prob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
엔터로 구분된 입력이 임의의 횟수만큼 이뤄진다.
`q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
여태까지 입력한 내용중 **정수**만을 선별하여,
`<첫번째 정수> + <두번째 정수> + <세번째 정수> = <총합>`
의 형태로 출력하시오.
 */
public class H1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            // 종료조건
            if ("q".equals(input)) break;
            try {
                // 번역 시도
                Integer inputInt = Integer.parseInt(input);
                inputList.add(inputInt);
            }
            // 정수로 번역이 안되면 무시
            catch (NumberFormatException ignored) {}
        }

        int sum = 0;
        for (int i = 0; i < inputList.size(); i++) {
            sum += inputList.get(i);
            System.out.print(inputList.get(i));
            if (i != inputList.size() - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println(String.format(" = %d", sum));
    }
}










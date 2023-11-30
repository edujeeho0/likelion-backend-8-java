package d7.collections.prob;

import java.util.*;

/*
엔터로 구분된 누군가의 이름 입력이 임의의 횟수만큼 이뤄진다.
`q`가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
여태까지 입력된 이름을 중복없이 알파벳 순서데로 출력하시오.
 */
public class H3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> inputSet = new HashSet<>();
        while (true) {
            String input = scanner.nextLine();
            if ("q".equals(input)) break;
            // 집합은 기본적으로 중복을 허용하지 않는다.
            inputSet.add(input);
        }
        // 순서를 위해 리스트로 변환
        List<String> names = new ArrayList<>(inputSet);
        // 정렬
        Collections.sort(names);
        // 출력
        for (String name : names) {
            System.out.println(name);
        }
    }
}

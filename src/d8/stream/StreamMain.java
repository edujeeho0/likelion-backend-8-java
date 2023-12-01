package d8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        String[] nameArray = {
                "Alex",
                "Dave",
                "Chad",
                "Brad"
        };
        // Stream<T>는 데이터가 흘러감을 나타내는 객체
        Stream<String> nameArrStream = Arrays.stream(nameArray);

        // 원시타입 스트림
        int[] intArray = {1, 23, 14, 53, 22, 15, 10, 6};
        IntStream intStream = Arrays.stream(intArray);

        // 문자열을 문자 스트림
        String email = "edujeeho@gmail.com";
        IntStream charStream = email.chars();

        // Collection.stream()
        List<String> nameList = new ArrayList<>();
        nameList.add("Alex");
        nameList.add("Dave");
        nameList.add("Chad");
        nameList.add("Brad");
        Stream<String> nameListStream = nameList.stream();
        /*
        Stream<String> nameStream1 = nameListStream.filter(name -> name.contains("a"));
        Stream<String> nameStream2 = nameStream1.map(name -> name.toLowerCase());
        Stream<String> nameStream3 = nameStream2.sorted(Comparator.reverseOrder());
         */

        nameListStream
                // 중간 작업
                // 데이터를 선별하는데,
                // 선별하는 기준을 전달해야 한다.
                // filter: 전달받은 함수를 바탕으로 참인 데이터만 남기는 Stream
                .filter(name -> name.contains("d"))
                // 데이터를 받아 새로운 데이터를 반환한다.
                .map(name -> name.toLowerCase())
                // .map(name -> name.length())
                // sorted: 데이터를 받아 전달받은 기준으로 정렬을 한다.
                .sorted(Comparator.reverseOrder())
                // 종결 작업
                // 새로운 데이터 모음을 바탕으로 결론을 내린다
                // forEach: 남은 데이터를 각각 전달받은 함수의 인자로 전달
                // .forEach(name -> System.out.println(name));
                // toList: 데이터를 새로운 리스트로 만들어서 반환
                // .toList();
                // allMatch, anyMatch, noneMatch
                // 전달받은 함수를 바탕으로, 1. 전체가 참인지, 2. 하나라도 참인지, 3. 전혀 참이 없는지
//                .allMatch(name -> name.length() >= 4)
//                .anyMatch(name -> name.length() > 5)
//                .noneMatch(name -> name.length() < 3)
                ;

        // 종결 작업 이후엔 다시 호출 불가
        /* error
        nameListStream
                .filter(name -> name.contains("a"))
                .forEach(System.out::println);
         */
        // Stream 작업은 원본에는 영향이 없다.
        // 새로운 데이터의 모음을 만드는 것.
        System.out.println(nameList);
        /*
        nameListStream
                .filter(name -> name.contains("d"))
                .map(name -> name.toLowerCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
         */

        nameListStream = nameList.stream();
        // 이름들 중에서
        // 길이는 4이상이며
        // 대문자 A가 들어가는
        // 모든 이름에 d가 포함이 안되어 있는지?
        boolean result = nameListStream
                // 길이는 4이상이며
                .filter(name -> name.length() >= 4)
                // 대문자 A가 들어가는
                .filter(name -> name.contains("A"))
                .noneMatch(name -> name.contains("d"));
        System.out.println(result);

        // 모든 숫자들 중에서
        // 홀수 이면서
        // 10 이상인 숫자들이
        // 3의 배수가 아닌지?
        // int[] intArray = {1, 23, 14, 53, 22, 15, 10, 6};
        boolean result2 = intStream
                .filter(num -> num % 2 == 1)
                .filter(num -> num >= 10)
                .noneMatch(num -> num % 3 == 0);
        System.out.println(result2);

        // 숫자들 중에서
        // 홀수인 수에
        // * 2를 한 숫자가
        // 전부 4의 배수인지?
        intStream = Arrays.stream(intArray);
        boolean result3 = intStream
                .filter(num -> num % 2 == 1)
                .map(num -> num * 2)
                .allMatch(num -> num % 4 == 0);
        System.out.println(result3);

        // 총합
        intStream = Arrays.stream(intArray);
        int sum = intStream.sum();
        System.out.println(sum);

        // 갯수
        intStream = Arrays.stream(intArray);
        long count = intStream.count();
        System.out.println(count);

        // 평균, 최소, 최대
        intStream = Arrays.stream(intArray);
        double avg = intStream.average()
                .orElse(0.0);  // Optional.orElse()
        System.out.println(avg);
    }

    public String toUpper(String input) {
        return input.toUpperCase();
    }

    // 입력은 무엇이며 결과는 무엇일까?
    public boolean predicate(String input) {
        // 문자열에 a가 포함되었는지 판단하는 메서드
        // return input.contains("a");
        // 문자열의 길이가 4이상인지 판단하는 메서드
        return input.length() >= 4;
    }
}

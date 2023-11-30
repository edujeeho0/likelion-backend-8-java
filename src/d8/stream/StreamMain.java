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
                // 데이터를 선별하는데,
                // 선별하는 기준을 전달해야 한다.
                // filter: 전달받은 함수를 바탕으로 참인 데이터만 남기는 Stream
                .filter(name -> name.contains("d"))
                // 데이터를 받아 새로운 데이터를 반환한다.
                .map(name -> name.toLowerCase())
                // .map(name -> {
                //    String nameLower = name.toLowerCase();
                //     String nameUpper = name.toUpperCase();
                //     return nameLower + nameUpper;
                // })
                // .map(name -> name.length())
                // 데이터를 받아 전달받은 기준으로 정렬을 한다.
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        /*
        nameListStream
                .filter(name -> name.contains("d"))
                .map(name -> name.toLowerCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
         */
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

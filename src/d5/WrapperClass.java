package d5;


public class WrapperClass {
    public static void main(String[] args) {
        // 1. 참조 타입이지만, String 처럼 값을 할당 가능
        String string = "";
        int primInt = 10;
        // int에 대응되는 참조 타입은 Integer
        Integer refInt = 10;

        // 2. 서로 상호 호환이 된다.
        refInt = primInt;
        primInt = refInt;

        // 3. 사칙연산도 그냥 참조 타입을 바탕으로 사용 가능하다.
        refInt *= 10;
        System.out.println(refInt);
        refInt /= primInt;
        System.out.println(refInt);

        Long refLong = 1000000000L;
        refLong *= 2;
        System.out.println(refLong);

        Character a = 'a';

        // 나름 유용한 기능들
        // 문자열 -> 정수 변환
        Integer parsedInt = Integer.parseInt("1000");
        System.out.println(parsedInt + 100);
        // 문자열 -> 실수 변환
        Double parsedDouble = Double.parseDouble("1.0");
        System.out.println(parsedDouble);
        parsedDouble = Double.parseDouble("3.141592");
        System.out.println(parsedDouble);
        // 문자열 -> Long 변환
        System.out.println(Long.parseLong("10000000000000000"));
        // 정수 최댓값 - 최솟값 상수
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // Long 최댓값 - 최솟값
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        // Double
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.POSITIVE_INFINITY);

        // String
        String sentence = "Hello, today is 27th of November";
        // 문자열 길이
        System.out.println(sentence.length());
        // 문자열 자르기
        System.out.println(sentence.substring(10));
        System.out.println(sentence.substring(7, 12));
        String[] strArray = sentence.split(" ");
        for (String str : strArray) {
            System.out.println(str);
        }

        String email = "edujeeho@gmail.com";
        String[] emailSplit = email.split("@");
        for (String str: emailSplit) {
            System.out.println(str);
        }
        // 특정 문자열 찾기
        String source = "https://google.com/search?q=";
        System.out.println(source.indexOf("google"));

        // 문자열 한글자씩 확인하는 방법
        // 1. fori 반복
        for (int i = 0; i < source.length(); i++) {
            // 문자열을 배열 취급해서 [i] 번째 가져오기
            System.out.print(source.charAt(i));
        }
        System.out.println();

        // 2. string.toCharArray()
        for (char letter : source.toCharArray()) {
            // 문자열 내부에 저장된 문자 배열 반환하기
            System.out.print(letter);
        }
        System.out.println();

        // 각 글자가 영문인지 숫자인지 확인하기
        source = "오늘 날씨가 따뜻은 하지만 비가 온데요 4도가 따뜻이라니";

        for (char letter : source.toCharArray()) {
            // 문자가 숫자를 나타내는 문자인지 확인
            if (Character.isDigit(letter)) {
                System.out.println(String.format("digit: %c", letter));
            }
            // 문자가 인간의 문자를 나타내는 문자인지 확인
            if (Character.isLetter(letter)) {
                System.out.println(String.format("letter: %c", letter));
            }
        }
    }
}

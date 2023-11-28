package d7.optional;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 에러가 될수도 안될수도.....
        // System.out.println(nullOrString().length());
        String nullable = nullOrString();
        if (nullable == null) System.out.println("got: null");
        else System.out.println(nullable);

        Optional<String> optionalString = Optional.ofNullable(nullOrString());
        if (optionalString.isPresent()) {
            System.out.println(optionalString.get());
        } else {
            System.out.println("got: null");
        }

        String result = Optional.ofNullable(nullOrString()).orElse("got: null");
        System.out.println(result);
    }


    public static String nullOrString() {
        Random random = new Random();
        if (random.nextInt() % 2 == 0)
            return "not null string";
        else return null;
    }
}

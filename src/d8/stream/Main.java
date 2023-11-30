package d8.stream;

public class Main {
    public static void main(String[] args) {
        // 여기에 새로운 값을 할당하고 싶다면?
        // 1. 전통적인 방법, 구현체 작성후 생성후 전달
        NoArgRetFunction function = new NoArgRetFunctionImpl();
        runFunction(function);

        // 2. 익명 내부 클래스로 일시적인 클래스 객체 전달
        NoArgRetFunction anClass = new NoArgRetFunction() {
            @Override
            public void noArgNoReturn() {
                System.out.println("Anonymous Inner Class");
            }
        };
        runFunction(anClass);

        // 3. 람다 표현식 (익명 함수)
        // 함수형 인터페이스는 어차피 구현할 메서드가 하나
        // 그러면 나머지 다 생략하고 그 메서드만 표시하자.
        // (왼쪽: 매개변수) -> (오른쪽: 함수 코드)
        NoArgRetFunction lambda = () -> System.out.println("Lambda Expression");
        runFunction(lambda);

        // 람다 내부에선 final 변수만 사용 가능
        final int a = 10;
        int b = 20;
        // 함수가 실행될 때 해당 변수에 접근할 수 있다는걸
        // 보장할 수 없다.
        NoArgRetFunction multilineLambda = () -> {
            System.out.println(a);
            // b = 30;  // error
            System.out.println("Multiline");
            System.out.println("Lambda");
        };
        runFunction(multilineLambda);

        // public int run(String str);
        StrArgIntRetFunction lambdaParams = str -> str.length();
        lambdaParams = str -> {
            System.out.println("multiline");
            return str.length();
        };
        System.out.println(runFunction(lambdaParams));

        // 메서드 직접 참조
        // 함수형 인터페이스의 형태와 동일한 메서드는
        // ::을 통해 직접 전달할 수 있다.
        runFunction(String::length);
    }

    public static int runFunction(StrArgIntRetFunction function){
        return function.run("Hello World!");
    }

    public static void runFunction(NoArgRetFunction function) {
        function.noArgNoReturn();
    }
}

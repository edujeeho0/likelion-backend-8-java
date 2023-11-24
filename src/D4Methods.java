public class D4Methods {

    // main 메서드
    public static void main(String[] args) {
        System.out.println("이것도 메서드 입니다!");
        System.out.println(addTwoInt(10, 20));

        int a = 10;
        int b = 10;
        // 두개의 정수를 더하고 두배 하여라.
//        int c = (a + b) * 2; // 요 뒤에 뭐가 올까요
        int c = addAndTwice(a, b);
        System.out.println(addAndTwice(c, c));
        System.out.println(threeIntAvg(a, b, c));
        int[] numbers = {-1, 0, 1};

        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                index = i;
                break;
            }
        }
        System.out.println(index);


        int[] nums = {2, 3, 1, 4, 6};
        System.out.println(findOneReturn(nums));
        System.out.println("------------");
        System.out.println(findOneBreak(nums));

        System.out.println("재귀함수");
        System.out.println(factorial(7));

        int intA = 2, intB = 3;
        long longA = 2, longB = 3;
        System.out.println(add(intA, intB));
        System.out.println(add(longA, longB));
        System.out.println(add(intA, longB));

//        System.out.println("avg of 1, 2, 3, 4, 5: " + varargAvg(1, 2, 3, 4, 5));
//        System.out.println("avg of 10, 12, 14: " + varargAvg(10, 12, 14));
//        System.out.println("avg of 2, 4, 5, 7: " + varargAvg(2, 4, 5, 7));
        int[] argList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("avg of 1 ~ 10: " + varargAvg(2, argList));
    }

    // Varargs - 가변인자
    // public static int varargAvg(int[] ints)
    public static int varargAvg(int... ints){
        int sum = 0;
        // 사용은 배열 쓰듯이
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum / ints.length;
    }
    public static int varargAvg(int offset, int... ints) {
        int sum = offset;
        // 사용은 배열 쓰듯이
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum / ints.length;
    }


    // 메서드 오버로딩
    // 이름은 같은, 매개변수 형태가 다른 메서드를
    // 여러개 만들 수 있게 해준다.
    // 메소드 호출하는 코드에서 코드 활용도가 높아진다.
    public static int add(int a, int b) {  // int + int
        return a + b;
    }
    public static long add(long a, long b) {  // long + long
        return a + b;
    }
    public static long add(int a, long b) {
        return a + b;
    }


    // n! = n * (n - 1)!
    // n == 1 || n == 0 -> n! = 1
    // F(0) = 1
    // F(1) = 1
    // F(n) = n * F(n - 1)
    public static int factorial(int n) {
        // 0이나 1이면 1을 반환한다.
        if (n == 1 || n == 0) {
            return 1;
        }
        // 아니면 n * f(n-1)를 반환한다.
        else {
            return n * factorial(n - 1);
        }
    }


    // 정수 배열을 받아서, 1이 어디있는지 반환하거나, 없으면 -1을 반환하는 메서드
    public static int findOneReturn(int[] numbers) {
        // 부정 데이터 방지도 가능
        if (numbers.length == 0) {
            // 배열의 길이가 0이면 데이터가 없으니 굳이 찾을필요 없음
            return -1;
        }
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            // 찾았다!
            if (numbers[i] == 1) {
                index = i;
                return index;
            }
        }
        System.out.println("for 종료");
        return index;
    }

    public static int findOneBreak(int[] numbers) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                index = i;
                break;
            }
        }
        System.out.println("for 종료");
        return index;
    }

    // 세개의 정수를 받아서, 합한 후 3으로 나눈 몫을 반환하는 메서드
    public static int threeIntAvg(int a, int b, int c) {
//        int sum = a + b + c;
//        int gAvg = sum / 3;
//        return gAvg;
        return (a + b + c) / 3;
    }

    // 두개의 정수를 더하고 두배 해서 그 결과를 반환하는 메서드
    public static int addAndTwice(int a, int b) {
        // int a = 10;
        // int b = 10;
        // 두개의 정수를 더하고 두배 하여라.
        int c = (a + b) * 2; // 요 뒤에 뭐가 올까요
        return c;
    }

    // 두개의 정수를 더하고 그 결과를 반환하는 메서드
    public static int addTwoInt(int a, int b) {
        return a + b;
    }

}

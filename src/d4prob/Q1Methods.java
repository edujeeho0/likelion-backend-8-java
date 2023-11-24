package d4prob;

/*
어떤 정수를 받아서 절대값을 반환하는 메서드 "abs"를 작성하시오.

+

두 정수(int)를 인자로 받아,
두 정수 값의 차이의 절대값을 반환하는 메서드 "diff"를 작성하시오.
 */
public class Q1Methods {
    public static int abs(int a) {
        if (a > 0) {
            return a;
        } else {
            return -a;
        }
    }

    public static int diff(int a, int b) {
        return abs(a - b);
//        if (a > b) {
//            return a - b;
//        } else {
//            return b - a;
//        }
    }

    public static void main(String[] args) {

    }
}

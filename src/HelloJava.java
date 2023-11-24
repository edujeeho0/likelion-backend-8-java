import java.util.Scanner;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // 이건 한줄을 주석으로 바꿔줍니다.
        System.out.println("만나서 반갑습니다!");
        System.out.println("열심히 할게요");
        /*
        슬래시 별 + 별 슬래시 사이의 내용은 주석이 됩니다.
        * */
        System.out.println(1024);
        System.out.println(3.141592);

        // 사용자 입력도 받아봅시다.
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());

        scanner.nextLine();
        System.out.println(scanner.nextLine());
    }
}

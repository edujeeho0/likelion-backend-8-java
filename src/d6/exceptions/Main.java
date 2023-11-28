package d6.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Integer a = 10;
        Integer b = 0;
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
        // 예외발생 가능성 농후
        // System.out.println(divide(a, b));
        // System.out.println("Bye!");
        try {
            // 예외가 발생할 수 있을것 같은 곳
            System.out.println(divide(a, b));
            System.out.println(divideToDouble(a, b));
        }
        catch (ArithmeticException | NullPointerException exception) {
            // 예외가 발생하면 실행되는 곳
            System.out.println(String.format(
                    "Sorry, this happened: %s", exception.getMessage()
            ));
        }
//        catch (NullPointerException exception) {
//            // 또다른 예외가 발생하면 실행되는 곳
//            System.out.println("NPE!!!");
//        }
        finally {
            // 예외가 발생해서 catch가 실행되든 안되든 상관없이 실행되는 곳
            System.out.println("Bye!");
        }
        System.out.println(a);
        System.out.println(b);

        // checked exceptions
        readFileContents(".gitignore");
        readFileContents("file-not-exist");

        try {
            readFileThrows("file-not-exist");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        readFileThrows("file-not-exist");
    }

    public static void readFileThrows(String filename)
            throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
    }

    public static void readFileContents(String filename) {
        File file = new File(filename);
        // checked exception은
        // 어떻게든 코드 단위에서 예외처리를 선으로 해줘야 한다.
        // Scanner scanner = new Scanner(file);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }


    // 두개의 정수를 인자로 받아 나누어서 정수 결과를 반환하는 정적 메서드 `divide`
    public static int divide(int a, int b) {
        return a / b;
    }

    public static double divideToDouble(int a, int b) {
        // 수동으로 예외를 발생시키고 싶다
        if (b == 0) throw new ArithmeticException("Division by Zero");
        return (double) a / b;
    }
}












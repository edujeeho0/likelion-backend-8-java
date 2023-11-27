package d6.people;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 추상 클래스 Person
        Person alex = new Student("Alex", 20, "CSE");
        Person brad = new Student("Brad", 21, "CSE");
        Person chad = new Lecturer("Chad", 50, "OOP");
        Person dave = new Student("Dave", 25, "CSE");
        Person eric = new Student("Eric", 23, "MD");

        alex.sayHello();
        brad.sayHello();
        chad.sayHello();

        Person[] people = {alex, brad, chad};
        for (Person person : people) {
            person.sayHello();
        }

        // 추상 클래스는 인스턴스화 할 수 없다.
        // Person noName = new Person("name");

        people = new Person[]{alex, brad, chad, dave, eric};
        // 배열을 정렬하는 메서드
        Arrays.sort(people);
        for (Person person : people) {
            person.sayHello();
        }
    }
}

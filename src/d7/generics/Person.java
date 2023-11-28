package d7.generics;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    // 구현하는 인터페이스에 타입 파라미터를 전달하면
    // 오버라이딩 하는 메서드에서 타입을 명시하기 좋다.
    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
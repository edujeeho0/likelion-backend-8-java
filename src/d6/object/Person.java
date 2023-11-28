package d6.object;

import java.util.Objects;

/*
이름과 나이를 속성으로 가지고
모든 속성을 받는 생성자
 + 각 속성의 Getter
 */
public abstract class Person {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //    @Override
//    public String toString() {
//        return String.format("%s, age: %d", name, age);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        // 1. 실제로 두 변수의 값(할당된 주소)이 동일하냐
//        if (this == o) return true;
//        // 2. null이거나, 둘이 다른 클래스인가
////        if (o == null || this.getClass() != o.getClass())
////            return false;
//        // 서로 다른 자식클래스가 일치하게 하고 싶다면
//        if (!(o instanceof Person)) return false;
//        // 3. 나머지 속성을 비교하자.
//        Person other = (Person) o;
//        return
//                this.age == other.age &&
//                        this.name.equals(other.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

}

package d6.people;

/*
사람을 만들고 (이름) (인사를 할거지만, 누가 하는지에 따라 다르게 하고 싶다)
학생을 만들고 (이름, 전공) (인사)
강사를 만들고 (이름, 주제) (인사)
 */
public abstract class Person implements Comparable {
    @Override
    // Comparable에서 구현을 요구하는 메서드
    // 두개의 객체의 대소를 비교하기 위함
    // Java에서 제공하는 정렬 기능을 활용할 때 사용됨
    public int compareTo(Object o) {
        return age - ((Person) o).age;
    }

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



    // 추상 메서드: 작동법(메서드 바디) 작성하지 않고,
    // 상속 받은 클래스에 구현을 위임하는 메서드
    public abstract void sayHello();

    public String getName() {
        return this.name;
    }
}

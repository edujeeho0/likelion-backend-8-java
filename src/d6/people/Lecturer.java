package d6.people;


// 강사를 만들고 (이름, 주제) (인사)
public class Lecturer extends Person {
    private String subject;

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void sayHello() {
        System.out.println(String.format(
                "Hello, I'm %s, today's subject is %s.",
                getName(), this.subject
        ));
    }
}

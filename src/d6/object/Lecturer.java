package d6.object;

public class Lecturer extends Person {
    private String subject;

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lecturer";
    }
}

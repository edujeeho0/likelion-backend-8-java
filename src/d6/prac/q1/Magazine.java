package d6.prac.q1;

public class Magazine extends Book {
    private final int year;
    private final int month;
    private final String subject;

    public Magazine(String title, int pages, int year, int month, String subject) {
        super(title, pages);
        this.year = year;
        this.month = month;
        this.subject = subject;
    }

    @Override
    public void printInfo() {
        System.out.println(String.format("title: %s", getTitle()));
        System.out.println(String.format("pages: %d", getPages()));
        System.out.println(String.format("year: %d", year));
        System.out.println(String.format("month: %d", month));
        System.out.println(String.format("subject: %s", subject));
    }
}

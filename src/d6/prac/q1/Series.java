package d6.prac.q1;

public class Series extends Book {
    private final String author;
    private final String subtitle;
    private final int volume;

    public Series(String title, int pages, String author, String subtitle, int volume) {
        super(title, pages);
        this.author = author;
        this.subtitle = subtitle;
        this.volume = volume;
    }

    @Override
    public void printInfo() {
        System.out.println(String.format("title: %s", getTitle()));
        System.out.println(String.format("pages: %d", getPages()));
        System.out.println(String.format("author: %s", author));
        System.out.println(String.format("subtitle: %s", subtitle));
        System.out.println(String.format("volume: %d", volume));
    }
}

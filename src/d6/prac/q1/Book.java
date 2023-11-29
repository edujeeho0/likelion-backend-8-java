package d6.prac.q1;

public abstract class Book {
    private String title;
    private int pages;

    public Book() {
    }

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public abstract void printInfo();

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}

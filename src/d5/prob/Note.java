package d5.prob;

public class Note {
    private final String title;
    private String[] pages;

    public Note(String title, int pages) {
        this.title = title;
        this.pages = new String[pages];
    }

    public void write(int page, String content) {
        pages[page] = content;
    }

    public String read(int page) {
        return pages[page];
    }

    public int wrotePages() {
        int count = 0;
        for (String page : pages) {
            if (page != null) count++;
        }
        return count;
    }

    public void readAll() {
        for (String page : pages) {
            if (page != null) System.out.println(page);
        }
    }

    public String getTitle() {
        return title;
    }
}

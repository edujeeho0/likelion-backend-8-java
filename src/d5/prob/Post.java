package d5.prob;

import java.time.LocalDateTime;

public class Post {
    private String title;
    private String content;
    private final LocalDateTime created;
    private LocalDateTime updated;
    private final String password;

    public Post(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }

    public void printPost() {
        System.out.println(String.format("제목: %s", title));
        System.out.println(String.format("제목: %s", content));
        System.out.println(String.format("제목: %s", created));
        System.out.println(String.format("제목: %s", updated));
    }

    public boolean editTitle(String title, String password) {
        if (!this.password.equals(password)) {
            return false;
        }
        this.title = title;
        this.updated = LocalDateTime.now();
        return true;
    }

    public boolean editContent(String content, String password) {
        if (!this.password.equals(password)) {
            return false;
        }
        this.content = content;
        this.updated = LocalDateTime.now();
        return true;
    }
}

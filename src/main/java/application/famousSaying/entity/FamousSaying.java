package application.famousSaying.entity;

public class FamousSaying {
    private int id;
    private String author;
    private String contents;

    public FamousSaying(int id, String author, String contents) {
        this.id = id;
        this.author = author;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getList() {
        return this.id +
                " / " + this.author +
                " / " + this.contents;
    }
}

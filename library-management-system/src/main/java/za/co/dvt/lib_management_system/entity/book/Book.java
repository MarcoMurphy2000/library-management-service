package za.co.dvt.lib_management_system.entity.book;

public class Book {
    private String title;

    private String author;

    private String category;

    private int id;

    private boolean available;

    public Book(final String title, final String author, final String category, final int id) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.id = id;
        this.available = true;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%b", title, author, category, id, available);
    }
}


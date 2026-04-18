import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public int getBookCount() {
        return books.size();
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            // Deep copy: clone each book in the list
            for (Book book : this.books) {
                cloned.books.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed for Recommendation", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for: ").append(targetAudience).append("\n");
        sb.append("Books (").append(books.size()).append("):\n");
        for (int i = 0; i < books.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(books.get(i)).append("\n");
        }
        return sb.toString();
    }
}


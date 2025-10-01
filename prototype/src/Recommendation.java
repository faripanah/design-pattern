import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>(books); // کپی برای اطمینان
    }

    // Clone method
    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            copy.books = new ArrayList<>();
            for (Book b : this.books) {
                copy.books.add(b.clone());
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Getter/Setter
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for: ").append(targetAudience).append("\n");
        if (books.isEmpty()) sb.append("  (no books)\n");
        else {
            for (int i = 0; i < books.size(); i++) {
                sb.append(String.format("  %d) %s\n", i + 1, books.get(i).toString()));
            }
        }
        return sb.toString();
    }
}

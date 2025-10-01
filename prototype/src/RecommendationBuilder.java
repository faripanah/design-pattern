import java.util.ArrayList;
import java.util.List;

public class RecommendationBuilder {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Recommendation getResult() {
        return new Recommendation(targetAudience, books);
    }
}


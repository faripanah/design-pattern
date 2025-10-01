public class Director {
    public void constructSciFiRecommendation(RecommendationBuilder builder) {
        builder.setTargetAudience("Science Fiction Fans");
        builder.addBook(new Book("Isaac Asimov", "Foundation", "Sci-Fi", 1951));
        builder.addBook(new Book("Frank Herbert", "Dune", "Sci-Fi", 1965));
    }

    public void constructKidsRecommendation(RecommendationBuilder builder) {
        builder.setTargetAudience("Kids");
        builder.addBook(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "Fantasy", 1997));
        builder.addBook(new Book("Rick Riordan", "Percy Jackson & the Olympians", "Fantasy", 2005));
    }
}


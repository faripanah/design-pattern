import java.nio.file.AccessDeniedException;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Unprotected
        library.addUnprotectedDocument("doc1", "This is a public document.");

        // Protected
        library.addProtectedDocument("doc2", "This is a secret document.", "alice", "bob");

        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        try {
            System.out.println("Alice reads doc1: " +
                    library.getDocument("doc1").getContent(alice));

            System.out.println("Alice reads doc2: " +
                    library.getDocument("doc2").getContent(alice));

            System.out.println("Bob reads doc2: " +
                    library.getDocument("doc2").getContent(bob));

            System.out.println("Charlie tries doc2: " +
                    library.getDocument("doc2").getContent(charlie));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
    }

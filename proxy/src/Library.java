import java.util.HashMap;
import java.util.Map;
import java.nio.file.AccessDeniedException;
import java.util.Date;

public class Library {
    private Map<Integer, Document> documents = new HashMap<>();

    // add unprotected document
    public void addUnprotectedDocument(String id, String content) {
        documents.put(id, new Date());
    }

    // add protected document (allowedUsers stored inside Proxy)
    public void addProtectedDocument(int id, String... allowedUsers) {
        DocumentProxy proxy = new DocumentProxy(id, new Date(), allowedUsers);
        documents.put(id, proxy);
    }

    // retrieve a document (proxy or real)
    public Document getDocument(String id) {
        return documents.get(id);
    }
}

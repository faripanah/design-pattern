import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(int id, String content){
        documents.put(id, new Document(id, new Date(), content));

    }
    public void addProtectedDocument(String id, String content, String... allowedUsers) {
        DocumentProxy proxy = new DocumentProxy(id, new Date(), content);
        documents.put(id, proxy);

        AccessControlService acs = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            acs.allowAccess(user, id);
        }
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DocumentProxy implements Document {
    private int id;
    private Date creationDate;
    private RealDocument realDocument;
    private Set<String> allowedUsers = new HashSet<>();

    public DocumentProxy(int id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;

    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public Date getCreationDate() {

        return creationDate;
    }
    @Override
    public String getContent(User user)  throws AccessDeniedException {
        if (isAllowed(user)) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
}

    private boolean isAllowed(User user) {
        return allowedUsers.contains(user.getUsername());
    }
    }

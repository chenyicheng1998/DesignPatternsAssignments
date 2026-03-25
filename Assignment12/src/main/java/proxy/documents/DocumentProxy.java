package proxy.documents;

import java.util.Date;

public class DocumentProxy implements Document {
    private RealDocument document;

    public DocumentProxy(RealDocument document) {
        this.document = document;
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public Date getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (!AccessControlService.getInstance().isAllowed(document.getId(), user.getUsername())) {
            throw new AccessDeniedException("Access denied for user " + user.getUsername() + " to document " + document.getId());
        }
        return document.getContent(user);
    }
}


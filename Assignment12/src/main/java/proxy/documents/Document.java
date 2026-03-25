package proxy.documents;

import java.util.Date;

public interface Document {
    String getId();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}


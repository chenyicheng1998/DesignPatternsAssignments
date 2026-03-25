package proxy.documents;

import java.util.Date;

public class RealDocument implements Document {
    private String id;
    private Date creationDate;
    private String content;

    protected RealDocument(String id, Date creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}


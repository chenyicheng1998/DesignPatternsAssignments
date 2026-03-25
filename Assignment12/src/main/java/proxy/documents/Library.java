package proxy.documents;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addUnprotectedDocument(String id, String content) {
        RealDocument doc = new RealDocument(id, new Date(), content);
        documents.put(id, doc);
    }

    public void addProtectedDocument(String id, String content) {
        RealDocument doc = new RealDocument(id, new Date(), content);
        DocumentProxy proxy = new DocumentProxy(doc);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}


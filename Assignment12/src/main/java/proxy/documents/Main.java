package proxy.documents;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        
        library.addUnprotectedDocument("doc1", "This is public information.");
        library.addProtectedDocument("doc2", "This is top secret information.");
        
        AccessControlService.getInstance().grantAccess("doc2", "alice");
        
        User alice = new User("alice");
        User bob = new User("bob");
        
        Document doc1 = library.getDocument("doc1");
        Document doc2 = library.getDocument("doc2");
        
        System.out.println("Alice reading doc1: ");
        try {
            System.out.println(doc1.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nBob reading doc1: ");
        try {
            System.out.println(doc1.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nAlice reading doc2 (Created: " + doc2.getCreationDate() + ")");
        try {
            System.out.println(doc2.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nBob reading doc2 (Created: " + doc2.getCreationDate() + ")");
        try {
            System.out.println(doc2.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}


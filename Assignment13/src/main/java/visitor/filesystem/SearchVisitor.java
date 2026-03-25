package visitor.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String extensionToFind;
    private final List<File> matches = new ArrayList<>();

    public SearchVisitor(String extensionToFind) {
        this.extensionToFind = extensionToFind == null ? "" : extensionToFind.toLowerCase();
    }

    @Override
    public void visit(File file) {
        String lowered = file.getName().toLowerCase();
        if (extensionToFind.isEmpty() || lowered.endsWith(extensionToFind)) {
            matches.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public List<File> getMatches() {
        return Collections.unmodifiableList(matches);
    }
}


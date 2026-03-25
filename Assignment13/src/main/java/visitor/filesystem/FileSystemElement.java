package visitor.filesystem;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}


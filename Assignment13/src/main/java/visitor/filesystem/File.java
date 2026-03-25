package visitor.filesystem;

public class File implements FileSystemElement {
    private final String name;
    private final long sizeInMb;

    public File(String name, long sizeInMb) {
        this.name = name;
        this.sizeInMb = sizeInMb;
    }

    public String getName() {
        return name;
    }

    public long getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}


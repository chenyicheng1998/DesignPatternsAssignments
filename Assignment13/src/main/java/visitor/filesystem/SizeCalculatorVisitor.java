package visitor.filesystem;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSizeMb = 0;

    @Override
    public void visit(File file) {
        totalSizeMb += file.getSizeInMb();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public long getTotalSizeMb() {
        return totalSizeMb;
    }
}


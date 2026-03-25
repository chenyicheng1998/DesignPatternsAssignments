package visitor.filesystem;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        Directory images = new Directory("images");
        Directory code = new Directory("code");

        docs.add(new File("report.pdf", 5));
        docs.add(new File("notes.txt", 1));
        images.add(new File("holiday.jpg", 2));
        images.add(new File("logo.png", 3));
        code.add(new File("Main.java", 1));
        code.add(new File("Utils.java", 2));

        root.add(docs);
        root.add(images);
        root.add(code);
        root.add(new File("readme.md", 1));

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size (MB): " + sizeCalculator.getTotalSizeMb());

        SearchVisitor javaSearch = new SearchVisitor(".java");
        root.accept(javaSearch);
        System.out.println("Java files found: ");
        for (File file : javaSearch.getMatches()) {
            System.out.println("- " + file.getName() + " (" + file.getSizeInMb() + " MB)");
        }
    }
}


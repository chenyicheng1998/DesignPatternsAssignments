public class Main {
    public static void main(String[] args) {
        System.out.println("=== Basic Printer ===");
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        System.out.println("\n=== XML Printer ===");
        Printer xmlPrinter = new XMLPrinter(new BasicPrinter());
        xmlPrinter.print("Hello World!");

        System.out.println("\n=== Encrypted Printer ===");
        Printer encryptedPrinter = new EncryptedPrinter(new BasicPrinter());
        encryptedPrinter.print("Hello World!");

        System.out.println("\n=== XML + Encrypted Printer ===");
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        System.out.println("\n=== Encrypted + XML Printer (different order) ===");
        Printer printer3 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer3.print("Hello World!");

        System.out.println("\n=== Demonstration of Decryption ===");
        String original = "Hello World!";
        String encrypted = "Khoor Zruog!";
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + EncryptedPrinter.decrypt(encrypted));
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Basic printer
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        System.out.println("----");

        // Decorated printer: XML + Encryption
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

    }
}
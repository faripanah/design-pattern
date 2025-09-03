// Concrete Decorator B: Encrypted Printer
class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    private String encrypt(String message) {
        // Simple Caesar Cipher (shift each char by 3)
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char) (c + 3));
        }
        return sb.toString();
    }

    private String decrypt(String encrypted) {
        // Just for demo, reverse Caesar shift
        StringBuilder sb = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            sb.append((char) (c - 3));
        }
        return sb.toString();
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        wrappedPrinter.print(encryptedMessage);

        // Optional: show decryption (for demonstration)
        System.out.println("Decrypted back: " + decrypt(encryptedMessage));
    }
}
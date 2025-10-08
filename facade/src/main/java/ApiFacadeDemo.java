import java.io.IOException;
public class ApiFacadeDemo {
public static void main(String[] args) {
    ApiFacade facade = new ApiFacade();

    // 1) Chuck Norris joke
    try {
        String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
        System.out.println("Chuck Norris joke: " + joke);
    } catch (IllegalArgumentException e) {
        System.err.println("Attribute not found: " + e.getMessage());
    } catch (IOException e) {
        System.err.println("IO/Network error: " + e.getMessage());
    }

    // 2) Example with currency rates (another public API)
    // We'll request an exchange-rates-like endpoint and fetch "rates" attribute.
    // Replace URL with any valid JSON API if this one isn't available in your environment.
    try {
        String rates = facade.getAttributeValueFromJson("https://api.exchangerate-api.com/v4/latest/USD", "rates");
        System.out.println("Exchange rates (truncated): " + (rates.length() > 200 ? rates.substring(0, 200) + "..." : rates));
    } catch (IllegalArgumentException e) {
        System.err.println("Attribute not found: " + e.getMessage());
    } catch (IOException e) {
        System.err.println("IO/Network error: " + e.getMessage());
    }
}
}

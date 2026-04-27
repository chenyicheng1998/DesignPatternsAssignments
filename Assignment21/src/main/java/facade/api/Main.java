package facade.api;

import java.io.IOException;

/**
 * Demonstrates the ApiAccessFacade using two public APIs:
 *   1. Chuck Norris joke API  – https://api.chucknorris.io/jokes/random
 *   2. FX rates API           – https://api.fxratesapi.com/latest
 *
 * The client only ever calls facade.getAttributeValueFromJson(); it never
 * touches HttpURLConnection, BufferedReader, or the JSON parser.
 */
public class Main {

    public static void main(String[] args) {
        ApiAccessFacade facade = new ApiAccessFacade();

        // -------------------------------------------------------
        // Demo 1: Chuck Norris joke
        // -------------------------------------------------------
        System.out.println("=== Chuck Norris Joke ===");
        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println(joke);
        } catch (IOException e) {
            System.err.println("Network error fetching joke: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Attribute not found: " + e.getMessage());
        }

        System.out.println();

        // -------------------------------------------------------
        // Demo 2: EUR → USD exchange rate from fxratesapi
        // The default base of this API is USD, so we pass ?base=EUR to get
        // rates quoted in EUR. The "USD" value in the response will then be
        // the actual EUR/USD exchange rate.
        // -------------------------------------------------------
        System.out.println("=== EUR/USD Exchange Rate ===");
        try {
            String usdRate = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest?base=EUR", "USD");
            System.out.println("1 EUR = " + usdRate + " USD");
        } catch (IOException e) {
            System.err.println("Network error fetching exchange rates: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Attribute not found: " + e.getMessage());
        }

        System.out.println();

        // -------------------------------------------------------
        // Demo 3: Error handling – bad URL → IOException
        // -------------------------------------------------------
        System.out.println("=== Error Demo: bad URL ===");
        try {
            facade.getAttributeValueFromJson("not-a-valid-url", "value");
        } catch (IOException e) {
            System.out.println("IOException caught (as expected): " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        // -------------------------------------------------------
        // Demo 4: Error handling – attribute not found → IllegalArgumentException
        // -------------------------------------------------------
        System.out.println("\n=== Error Demo: missing attribute ===");
        try {
            facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "nonExistentAttribute");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught (as expected): " + e.getMessage());
        }
    }
}


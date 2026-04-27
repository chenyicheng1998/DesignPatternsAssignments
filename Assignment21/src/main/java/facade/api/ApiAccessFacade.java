package facade.api;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * ApiAccessFacade – the facade class.
 *
 * It hides three subsystems from the client:
 *   - HttpRequester : opens the HTTP connection
 *   - ResponseHandler : reads the response body and validates the status code
 *   - JsonAttributeParser : parses JSON and extracts a named attribute
 *
 * The client only needs to call a single method:
 *   {@link #getAttributeValueFromJson(String, String)}
 */
public class ApiAccessFacade {

    // The three subsystems – the client is unaware of them
    private final HttpRequester httpRequester;
    private final ResponseHandler responseHandler;
    private final JsonAttributeParser jsonParser;

    public ApiAccessFacade() {
        this.httpRequester = new HttpRequester();
        this.responseHandler = new ResponseHandler();
        this.jsonParser = new JsonAttributeParser();
    }

    /**
     * Sends a GET request to {@code urlString}, reads the JSON response, and
     * returns the value of the first occurrence of {@code attributeName}.
     *
     * @param urlString     the URL to call (must be a valid HTTP/HTTPS URL)
     * @param attributeName the JSON attribute whose value we want
     * @return the value of the attribute as a String
     * @throws IOException              if the URL is invalid, the network call fails,
     *                                  or the server returns a non-2xx status
     * @throws IllegalArgumentException if the attribute is not found in the JSON,
     *                                  or the response body is not valid JSON
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {

        // Step 1 – open connection (subsystem 1)
        HttpURLConnection connection = httpRequester.openGetConnection(urlString);

        // Step 2 – read response (subsystem 2)
        String jsonBody = responseHandler.readResponse(connection);

        // Step 3 – parse and extract (subsystem 3)
        return jsonParser.extractAttribute(jsonBody, attributeName);
    }
}


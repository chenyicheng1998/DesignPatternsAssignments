package facade.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Subsystem 2 – responsible for reading the HTTP response body and
 * checking that the status code indicates success.
 *
 * Again, the client is never exposed to this class; only the facade uses it.
 */
public class ResponseHandler {

    /**
     * Reads the full response body from the given connection.
     *
     * @throws IOException if the HTTP status code is not 2xx, or if reading fails
     */
    public String readResponse(HttpURLConnection connection) throws IOException {
        int statusCode = connection.getResponseCode();
        if (statusCode < 200 || statusCode >= 300) {
            throw new IOException("HTTP request failed with status code " + statusCode
                    + " for URL: " + connection.getURL());
        }

        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        } finally {
            connection.disconnect();
        }
        return body.toString();
    }
}


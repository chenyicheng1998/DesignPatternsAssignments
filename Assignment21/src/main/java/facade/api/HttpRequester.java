package facade.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Subsystem 1 – responsible for opening an HTTP connection.
 *
 * The facade hides this class from the client; the client never
 * touches HttpURLConnection directly.
 */
public class HttpRequester {

    /**
     * Opens a GET connection to the given URL string.
     *
     * @throws IOException if the URL is malformed or the connection cannot be opened
     */
    public HttpURLConnection openGetConnection(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Set a reasonable timeout so the program doesn't hang forever
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            return connection;
        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }
    }
}


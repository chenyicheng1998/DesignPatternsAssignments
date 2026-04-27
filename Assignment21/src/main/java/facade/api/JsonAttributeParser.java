package facade.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Subsystem 3 – responsible for parsing a JSON string and extracting
 * the value of a named attribute.
 *
 * Only the facade interacts with this class; it is hidden from the client.
 */
public class JsonAttributeParser {

    /**
     * Parses the given JSON string and returns the value of {@code attributeName}
     * as a String.
     *
     * @throws IllegalArgumentException if the attribute is not present in the JSON,
     *                                   or if the JSON string cannot be parsed
     */
    public String extractAttribute(String json, String attributeName) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject root = (JSONObject) parser.parse(json);
            Object value = findAttributeRecursively(root, attributeName);
            if (value == null) {
                throw new IllegalArgumentException(
                        "Attribute '" + attributeName + "' not found in the JSON response.");
            }
            return value.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response: " + e.getMessage(), e);
        }
    }

    /**
     * Recursively searches the JSON object for the first key that matches attributeName.
     * Returns null if not found.
     */
    private Object findAttributeRecursively(JSONObject obj, String attributeName) {
        if (obj.containsKey(attributeName)) {
            return obj.get(attributeName);
        }
        // Search nested objects
        for (Object key : obj.keySet()) {
            Object child = obj.get(key);
            if (child instanceof JSONObject) {
                Object found = findAttributeRecursively((JSONObject) child, attributeName);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}


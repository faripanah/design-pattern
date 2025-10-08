import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {
    private static final int HTTP_OK = 200;
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        String json = getJsonFromApi(urlString);
        String result = extractAttributeFromJson(json, attributeName);
        if (result == null) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON from: " + urlString);
        }
        return result;
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(10_000);
        con.setReadTimeout(10_000);

        int status = con.getResponseCode();
        if (status != HTTP_OK) {
            // read error stream if available for more info (optional)
            String msg = "HTTP GET failed. Status: " + status + " for URL: " + apiUrl;
            con.disconnect();
            throw new IOException(msg);
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttributeFromJson(String json, String attributeName) throws IOException {
        JSONParser parser = new JSONParser();
        Object root;
        try {
            root = parser.parse(json);
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }

        // depth-first search for attributeName
        String found = searchForAttribute(root, attributeName);
        return found;
    }

    @SuppressWarnings("unchecked")
    private String searchForAttribute(Object node, String attributeName) {
        if (node instanceof JSONObject) {
            JSONObject obj = (JSONObject) node;
            // check keys in insertion order (but order not guaranteed); return first match
            if (obj.containsKey(attributeName)) {
                Object value = obj.get(attributeName);
                return jsonValueToString(value);
            }
            // otherwise traverse children
            for (Object key : obj.keySet()) {
                Object child = obj.get(key);
                String res = searchForAttribute(child, attributeName);
                if (res != null) return res;
            }
            return null;
        } else if (node instanceof JSONArray) {
            JSONArray arr = (JSONArray) node;
            for (Object item : arr) {
                String res = searchForAttribute(item, attributeName);
                if (res != null) return res;
            }
            return null;
        } else {
            // primitive: nothing to search inside
            return null;
        }
    }

    private String jsonValueToString(Object value) {
        if (value == null) return "null";
        if (value instanceof JSONObject || value instanceof JSONArray) {
            return value.toString(); // return JSON text representation
        }
        return value.toString(); // primitives (String, Number, Boolean)
    }
}

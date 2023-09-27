import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIDataFetcher {
    public static void main(String[] args) {
        try {
            // Define the API URL (replace with the actual API URL)
            String apiUrl = "https://api.exchangeratesapi.io/v1/2023-09-26?access_key=2e007e407e8433b66b1b107f228f7869&base=INR&symbols=USD,EUR,YEN,AED";


            // Fetch data from the API
            String apiResponse = fetchDataFromAPI(apiUrl);

            // Parse the API response and extract relevant data
            // Implement this part based on the API's response format
            // For demonstration purposes, we'll assume a JSON response.
            // You may need to use a JSON parsing library like Jackson or Gson.
            // Example: JSONObject responseData = new JSONObject(apiResponse);
            // Extract data from responseData and proceed to the next steps.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchDataFromAPI(String apiUrl) throws IOException {
        // Make an HTTP GET request to the API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the API response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        connection.disconnect();

        return response.toString();
    }
}


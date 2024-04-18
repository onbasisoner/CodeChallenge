package client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestAssuredClient {


    //Try for RestAPI connection
    public static void main(String[] args) {


        String countryCode = "ch";

        try {
            String currency = getCurrencyCode(countryCode);
            System.out.println("Currency for country code " + countryCode + ": " + currency);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Function for getting currency code with giving country code
    public static String getCurrencyCode(String countryCode) throws Exception {
        String apiUrl = "https://restcountries.com/v3.1/alpha/" + countryCode;

        // Create URL
        URL url = new URL(apiUrl);

        // Create HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set request method, GET is enough for this project
        conn.setRequestMethod("GET");

        // Get the response code, need response code assertion for getting response body
        int responseCode = conn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Make sure response is in jsonArray format
            JSONArray jsonArray = new JSONArray(response.toString());
            if (jsonArray.length() > 0) {
                JSONObject countryObj = jsonArray.getJSONObject(0);
                //Get Currencies array on JSONArray
                JSONArray currenciesArray = countryObj.getJSONObject("currencies").names();
                if (currenciesArray.length() > 0) {
                    // Extract the currency information, we only need currency code so other object is not necessary to get
                    String currencyCode = currenciesArray.getString(0);
                    JSONObject currencyObj = countryObj.getJSONObject("currencies").getJSONObject(currencyCode);
                    //String currencyName = currencyObj.getString("name");
                    //String currencySymbol = currencyObj.getString("symbol");
                    return currencyCode;
                   // return "Currency Code: " + currencyCode + ", Currency Name: " + currencyName + ", Currency Symbol: " + currencySymbol;
                } else {
                    return "Currency information not found for the specified country code.";
                }
            }
        }
        return "Country information not found for the specified country code.";
    }
}


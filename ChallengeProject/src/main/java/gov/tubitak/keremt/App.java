package gov.tubitak.keremt;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /*
        try{
            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo");
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode!=200)
                throw new RuntimeException("HttpResponseCode: "+responseCode);
            else{
                StringBuilder informationString = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()){
                    informationString.append(sc.nextLine());
                }
                sc.close();
                System.out.println(informationString);

                JSONParser parser = new JSONParser();

                //JSONArray dataObject=(JSONArray) parser.parse(String.valueOf(informationString));
                JSONObject dataObject= (JSONObject) parser.parse(String.valueOf(informationString));
                System.out.println(dataObject.get(0));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
         */
    }
}

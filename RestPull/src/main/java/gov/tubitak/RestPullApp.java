package gov.tubitak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestPullApp {
    public static void main(String[] args) {
        SpringApplication.run(RestPullApp.class,args);
        /*
        try{
            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&interval=15min&apikey=YJLNB9RRPZW4L704");
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
                //    System.out.println(informationString);

                JSONParser parser = new JSONParser();

                //JSONArray dataObject=(JSONArray) parser.parse(String.valueOf(informationString));
                JSONObject dataObject= (JSONObject)parser.parse(String.valueOf(informationString));
                dataObject.keySet().forEach(item -> {
                    System.out.println(item);
                });
                System.out.println(dataObject.get("Time Series (Daily)"));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        */
    }
}

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestPullApp {
    public static void main(String[] args) {
    /*main
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    */
    /* controller
    private static final String webUrl=
    "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=compact&apikey=YJLNB9RRPZW4L704";

    @Autowired
    private RestTemplate template;

    @GetMapping("/test")
    public ResponseEntity<String> getStockData(){
        ResponseEntity<List> data = template.getForEntity(webUrl, List.class);
        return ResponseEntity.ok(Objects.requireNonNull(data.getBody()).toString());
    }*/
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
                /*dataObject.keySet().forEach(item -> {
                    System.out.println(item);
                });*/
                System.out.println(dataObject.get("Time Series (Daily)"));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

package gov.tubitak.keremt.loader;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.dto.TimeSeriesQueryResult;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@RestController
public class StockLoader extends TimerTask {
    private final RestTemplate restTemplate;
    private final StockService stockService;
    private final String[] symbols= {"IBM","AAPL","TSCO.LON","GPV.TRV","DAI.DEX"};
    private LocalDate yesterday;
    Timer timer = new Timer();

    public StockLoader(RestTemplate restTemplate, StockService stockService){
        this.restTemplate = restTemplate;
        this.stockService = stockService;
        if (stockService.isRepositoryEmpty()) {
            for (String symbol : symbols) {
                loadToDB(symbol);
            }
        }
        else
            timer.schedule(this,0, 86400000);

    }
    @Override
    public void run() {
        checkDBandYesterday();
    }

    /**
     * Checking database and yesterday
     * reason of yesterday day is final data always belongs to previous day
     * */
    public void checkDBandYesterday(){
        yesterday = LocalDate.now().minusDays(1);
        String day = yesterday.getDayOfWeek().toString();
        if(!day.equals("SUNDAY") && !day.equals("SATURDAY")) {
            if (stockService.getStocks(null, yesterday.toString()).isEmpty()) {
                for (String symbol : symbols)
                    loadToDBDaily(symbol, yesterday.toString());
            }
            else System.out.println("√----> All Data Already Recorded");
        }
        else System.out.println("X----> Yesterday was "+day+ ". There is NOT New Data!");
    }

    /**
     * Filling for empty database
     * */
    private void loadToDB(String symbol){
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="
                        +symbol+"&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));
        if (response.getBody().getTimeSeries()!=null) {
            HashMap<String, StockDto> temp = response.getBody().getTimeSeries();
            for (Map.Entry<String, StockDto> map : temp.entrySet()) {
                stockService.save(map.getValue(), map.getKey(), symbol);
            }
            System.out.println("√----> All Data Has Been Recorded");
        }
        else System.out.println("X----> Response is NULL !!!");
    }

    /**
     * Final data is added to database
     * */
    private void loadToDBDaily(String symbol, String date) {
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="
                        +symbol+"&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));
        if (response.getBody().getTimeSeries()!=null) {
            HashMap<String, StockDto> temp = response.getBody().getTimeSeries();
            for (Map.Entry<String, StockDto> map : temp.entrySet()) {
                if (map.getKey().equals(date)) {
                    stockService.save(map.getValue(), map.getKey(), symbol);
                    System.out.println("√----> New Data Has Been Recorded");
                    break;
                }
            }
        }
        else System.out.println("X----> Response is NULL !!!");
    }
}

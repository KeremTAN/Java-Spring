package gov.tubitak.keremt.loader;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.dto.TimeSeriesQueryResult;
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

    private boolean isScheduleStarted=false;

    private LocalDate yesterday;

    Timer timer = new Timer();

    public StockLoader(RestTemplate restTemplate, StockService stockService) throws InterruptedException {
        this.restTemplate = restTemplate;
        this.stockService = stockService;
        if (stockService.isRepositoryEmpty()) {
            for (String symbol : symbols)
                loadToDB(symbol);
        }
        /*
        else if(!isScheduleStarted)
            isScheduleStarted=true;
            timer.schedule(this,0, 86400000);

         */
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
                System.out.println("here");
                for (String symbol : symbols)
                    loadToDBDaily(symbol, yesterday.toString());
            }
            else System.out.println("√----> All Data Recorded");
        }
        else System.out.println("X----> Yesterday was "+day+ ". There is not new data!");
    }

    /**
     * Filling for empty database
     * */
    private void loadToDB(String symbol){
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                        +symbol+"&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));

            HashMap<String, StockDto> temp = response.getBody().getTimeSeries();
            for (Map.Entry<String, StockDto> map : temp.entrySet()) {
                stockService.save(map.getValue(), map.getKey(), symbol);
            }

    }

    /**
     * Final data is added to database
     * */
    private void loadToDBDaily(String symbol, String date) {
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                        +symbol+"&outputsize=compact&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));
        if (response.getBody().getTimeSeries()!=null) {
            HashMap<String, StockDto> temp = response.getBody().getTimeSeries();
            for (Map.Entry<String, StockDto> map : temp.entrySet()) {
                if (map.getKey().equals(date)) {
                    stockService.save(map.getValue(), map.getKey(), symbol);
                    break;
                }
            }
        }
        else System.out.println("X----> Response is NULL !!!");
    }

}

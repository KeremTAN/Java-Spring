package gov.tubitak.keremt.loader;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.dto.TimeSeriesQueryResult;
import gov.tubitak.keremt.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StockLoader {
    private final RestTemplate restTemplate;
    private final StockService stockService;
    private final String[] symbols= {"IBM", "AAPL","TSCO.LON","GPV.TRV","DAI.DEX"};

    public StockLoader(RestTemplate restTemplate, StockService stockService) {
        this.restTemplate = restTemplate;
        this.stockService = stockService;
        if (stockService.isRepositoryEmpty())
            for (String symbol : symbols)
                loadToDB(symbol);
    }

    private void loadToDB(String symbol) {
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                 +symbol+"&outputsize=compact&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));
        HashMap<String, StockDto> temp =  response.getBody().getTimeSeries();
        for (Map.Entry<String, StockDto> map : temp.entrySet()){
            stockService.save(map.getValue(), map.getKey(), symbol);
        }
    }
}

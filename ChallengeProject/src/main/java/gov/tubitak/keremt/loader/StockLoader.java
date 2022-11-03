package gov.tubitak.keremt.loader;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.entity.TimeSeriesQueryResult;
import gov.tubitak.keremt.repositories.StockRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/loader")
@RequiredArgsConstructor
public class StockLoader {
    private final RestTemplate restTemplate;
    private final StockRepository stockRepository;
    @GetMapping("/{symbol}")
    public ResponseEntity<TimeSeriesQueryResult> loadDB(@PathVariable(value = "symbol") String symbol) {
        String webUrl=
                "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                 +symbol+"&outputsize=compact&apikey=YJLNB9RRPZW4L704";
        ResponseEntity<TimeSeriesQueryResult> response = (restTemplate.getForEntity(webUrl, TimeSeriesQueryResult.class));
        Map<String, StockDto> temp =  response.getBody().getTimeSeries();
        for (Map.Entry<String, StockDto> map : temp.entrySet()){
            System.out.println(map.getKey() + " "+map.getValue());
        }
        return response;
    }
}

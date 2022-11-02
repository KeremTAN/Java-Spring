package gov.tubitak.keremt.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.loader.StockLoader;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class RestClientController {
    private final StockRepository stockRepository;
    private final RestTemplate restTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final StockLoader loader = new StockLoader();
    private static String webUrl=
    "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=compact&apikey=YJLNB9RRPZW4L704";

    @SuppressWarnings("unused")
    private final StockService stockService;

    @PostConstruct
    public void init(){
        for (int i=0; i<7; i++){
            Stock stock = new Stock();
            stock.setOpen(loader.getOpen()[i]);
            stock.setHigh(loader.getHigh()[i]);
            stock.setLow(loader.getLow()[i]);
            stock.setClose(loader.getClose()[i]);
            stock.setVolume(loader.getVolume()[i]);
            stockRepository.save(stock);
        }
    }
    @PostMapping("/save-stock")
    public ResponseEntity<Stock> save(@RequestBody Stock stock){
        System.out.println(stock);
        return ResponseEntity.ok(stockRepository.save(stock));
    }

    /**
     * It is not working correctly.
     * */
    @GetMapping("/get-api-data")
    public ResponseEntity<JsonNode> get() throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity(webUrl, String.class);
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode allData = root.get("Time Series (Daily)");
        Iterator<JsonNode> values = allData.elements();
       System.out.println(allData);
        return ResponseEntity.ok(allData);
    }
    @GetMapping("/get-stock")
    public ResponseEntity<List<Stock>> getFromH2(){
        List<Stock> ret = new LinkedList<>();
        for (Stock stock : stockRepository.findAll())
            ret.add(stock);
        return ResponseEntity.ok(ret);
    }
    @GetMapping("/check")
    public  ResponseEntity<String> getCheck(){
        return ResponseEntity.ok("It is working");
    }
}

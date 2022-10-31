package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class RestClientController {
    private final StockRepository stockRepository;
    private final RestTemplate restTemplate;
    private static String webUrl=
    "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=compact&apikey=YJLNB9RRPZW4L704";

    @SuppressWarnings("unused")
    private final StockService stockService;

    @PostMapping("/h2")
    public ResponseEntity<Stock> add(@RequestBody Stock stock){
        System.out.println(stock);
        return ResponseEntity.ok(stockRepository.save(stock));
    }
    @GetMapping
    public Object get(){
        Object objectResponseEntity = restTemplate.getForEntity(webUrl, Object.class);
        System.out.println(objectResponseEntity);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/h2")
    public ResponseEntity<List<Stock>> getFromH2(){
        List<Stock> ret = new LinkedList<>();
        for (Stock stock : stockRepository.findAll())
            ret.add(stock);
        return ResponseEntity.ok(ret);
    }
    @GetMapping("/check")
    public  ResponseEntity<String> getS(){

        return ResponseEntity.ok("It is working");
    }
}

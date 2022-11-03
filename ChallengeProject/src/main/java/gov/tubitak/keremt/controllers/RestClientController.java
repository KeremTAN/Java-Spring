package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.loader.StockLoader;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class RestClientController {
    private final StockRepository stockRepository;
    private final StockLoader loader;

    @SuppressWarnings("unused")
    private final StockService stockService;

    /*
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
    }*/
    @PostMapping("/save-stock")
    public ResponseEntity<Stock> save(@RequestBody Stock stock){
        return ResponseEntity.ok(stockRepository.save(stock));
    }
    @PostMapping("/save-list-stock")
    public ResponseEntity<Iterable<Stock>> save(@RequestBody List<Stock> listStock){
        return ResponseEntity.ok(stockRepository.saveAll(listStock));
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
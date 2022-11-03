package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockRepository stockRepository;

    @SuppressWarnings("unused")
    private final StockService stockService;

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
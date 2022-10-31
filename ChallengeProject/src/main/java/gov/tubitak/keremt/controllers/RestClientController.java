package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class RestClientController {
    private final StockRepository stockRepository;

    @SuppressWarnings("unused")
    private final StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> add(@RequestBody Stock stock){
        System.out.println(stock);
        return ResponseEntity.ok(stockRepository.save(stock));
    }
    @GetMapping
    public  ResponseEntity<List<Stock>> get(){
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

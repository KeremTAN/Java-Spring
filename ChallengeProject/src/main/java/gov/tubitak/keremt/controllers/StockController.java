package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/v1/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping
    public ResponseEntity<StockDto> save(@RequestBody StockDto stockDto,
                                         @RequestParam String symbol,
                                         @RequestParam String date){
        return ResponseEntity.ok(stockService.save(stockDto, date, symbol));
    }
    @GetMapping()
    public ResponseEntity<List<StockDto>> getStocks(@RequestParam(required = false) String symbol,
                                                    @RequestParam(required = false) String date){
        return ResponseEntity.ok(stockService.getStocks(symbol,date));
    }
    @GetMapping("/price")
    public ResponseEntity<BigDecimal> getPrice(@RequestParam String symbol,
                                               @RequestParam String date,
                                               @RequestParam String type){
        return ResponseEntity.ok(stockService.getPrice(symbol,date,type));
    }
    @DeleteMapping("/del")
    public void  deleteAll(){
        stockService.deleteAll();
    }

}
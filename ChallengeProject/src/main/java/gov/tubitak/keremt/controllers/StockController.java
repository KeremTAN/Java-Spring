package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping("/save-stock/{symbol}/{date}")
    public ResponseEntity<StockDto> save(@RequestBody StockDto stock,
                                         @PathVariable(value = "symbol") String symbol,
                                         @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.save(stock, date, symbol));
    }
    @GetMapping("/get-stock-all")
    public ResponseEntity<List<StockDto>> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/get-stock/{symbol}/{date}")
    public  ResponseEntity<StockDto> getPrices(@PathVariable(value = "symbol") String symbol,
                                               @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getPrices(symbol,date));
    }
}
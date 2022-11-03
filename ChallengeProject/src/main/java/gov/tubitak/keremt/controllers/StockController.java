package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
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
    @PostMapping("/save-stock/{date}/{symbol}")
    public ResponseEntity<StockDto> save(@RequestBody StockDto stock,@PathVariable(value = "date") String date, @PathVariable(value = "symbol") String symbol){
        return ResponseEntity.ok(stockService.save(stock, date, symbol));
    }
    @GetMapping("/get-stock-all")
    public ResponseEntity<List<StockDto>> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }
}
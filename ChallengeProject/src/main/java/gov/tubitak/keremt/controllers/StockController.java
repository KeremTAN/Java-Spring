package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping("/{symbol}/{date}")
    public ResponseEntity<StockDto> save(@RequestBody StockDto stock,
                                         @PathVariable(value = "symbol") String symbol,
                                         @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.save(stock, date, symbol));
    }
    @GetMapping
    public ResponseEntity<List<StockDto>> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/{symbol}/{date}")
    public ResponseEntity<StockDto> getPrices(@PathVariable(value = "symbol") String symbol,
                                               @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getPrices(symbol,date));
    }
    @GetMapping("/open/{symbol}/{date}")
    public ResponseEntity<BigDecimal> getOpenPrice(@PathVariable(value = "symbol") String symbol,
                                                    @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getOpenPrice(symbol,date));
    }
    @GetMapping("/high/{symbol}/{date}")
    public ResponseEntity<BigDecimal> getHighPrice(@PathVariable(value = "symbol") String symbol,
                                                    @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getHighPrice(symbol,date));
    }
    @GetMapping("/low/{symbol}/{date}")
    public ResponseEntity<BigDecimal> getLowPrice(@PathVariable(value = "symbol") String symbol,
                                                    @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getLowPrice(symbol,date));
    }
    @GetMapping("/close/{symbol}/{date}")
    public ResponseEntity<BigDecimal> getClosePrice(@PathVariable(value = "symbol") String symbol,
                                                    @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getClosePrice(symbol,date));
    }
    @GetMapping("/volume/{symbol}/{date}")
    public ResponseEntity<BigDecimal> getVolumePrice(@PathVariable(value = "symbol") String symbol,
                                                     @PathVariable(value = "date") String date){
        return ResponseEntity.ok(stockService.getVolumePrice(symbol,date));
    }
    /*
    @DeleteMapping("/del")
    public void  deleteAll(){
        stockService.deleteAll();
    }
    */
}
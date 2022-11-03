package gov.tubitak.keremt.converter;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StockConverter {
    public Stock convertToStock(StockDto stockDto, String date, String symbol){
        return new Stock((long) 0.0,date,symbol, stockDto.getOpen(),stockDto.getHigh(), stockDto.getLow(), stockDto.getClose(),stockDto.getVolume());
    }
    public StockDto convertToStockDto(Stock stock){
        return new StockDto(stock.getDate(),stock.getSymbol(),stock.getOpen(),stock.getHigh(), stock.getLow(), stock.getClose(),stock.getVolume());
    }
}

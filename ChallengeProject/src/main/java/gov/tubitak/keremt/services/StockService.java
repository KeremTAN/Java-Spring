package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.repositories.StockRepository;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final StockConverter stockConverter;
    public StockDto save(StockDto stockDto, String date, String symbol){
       stockRepository.save(stockConverter.convertToStock(stockDto,date,symbol));
       return stockDto;
    }
    /**
     * If symbol and date are NOT NULL
     * then it returns a list which has one element.
     * However, If symbol and date are NULL
     * then it returns a list which has all elements.
     */
    public List<StockDto> getStocks(String symbol, String date){
        List<StockDto> ret = new LinkedList<>();
        if (symbol==null && date==null)
            stockConverter.convertToAllAsStockDTO(ret, stockRepository.findAll());
        else if (symbol!=null && date!=null)
            ret.add(stockConverter.convertToStockDto(stockRepository.findBySymbolAndDate(symbol, date)));
        else if (symbol!=null)
            stockConverter.convertToAllAsStockDTO(ret, stockRepository.findBySymbol(symbol));
        else
            stockConverter.convertToAllAsStockDTO(ret, stockRepository.findByDate(date));
        return ret;
    }
    public BigDecimal getPrice(String symbol, String date, String type){
        return switch (type) {
            case "open" -> getStocks(symbol, date).get(0).getOpen();
            case "high" -> getStocks(symbol, date).get(0).getHigh();
            case "low" -> getStocks(symbol, date).get(0).getLow();
            case "close" -> getStocks(symbol, date).get(0).getClose();
            case "volume" -> getStocks(symbol, date).get(0).getVolume();
            default -> BigDecimal.valueOf(-1);
        };
    }
    public boolean isRepositoryEmpty(){
        return stockRepository.count() == 0;
    }
    public void deleteAll(){
        stockRepository.deleteAll();
    }
}

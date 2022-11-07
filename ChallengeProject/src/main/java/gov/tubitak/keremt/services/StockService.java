package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
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
    public List<StockDto> getAll(){
        List<StockDto> ret = new LinkedList<>();
        for (Stock stock : stockRepository.findAll())
            ret.add(stockConverter.convertToStockDto(stock));
        return ret;
    }
    public StockDto getPrices(String symbol, String date){
        return stockConverter.convertToStockDto(stockRepository.findBySymbolAndDate(symbol, date));
    }

    public BigDecimal getPrice(String symbol, String date, String type){
        if (type.equals("open"))
            return getPrices(symbol,date).getOpen();
        else if (type.equals("high"))
            return getPrices(symbol,date).getHigh();
        else if (type.equals("low"))
            return getPrices(symbol,date).getLow();
        else if (type.equals("close"))
            return getPrices(symbol,date).getClose();
        else if (type.equals("volume"))
            return getPrices(symbol,date).getVolume();
        return BigDecimal.valueOf(-1);
    }
    public boolean isRepositoryEmpty(){
        return stockRepository.count() == 0;
    }
    public void deleteAll(){
        stockRepository.deleteAll();
    }
}

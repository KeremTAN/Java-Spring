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
    public BigDecimal getOpenPrice(String symbol, String date){
        return getPrices(symbol,date).getOpen();
    }
    public BigDecimal getHighPrice(String symbol, String date){
        return getPrices(symbol,date).getHigh();
    }
    public BigDecimal getLowPrice(String symbol, String date){
        return getPrices(symbol,date).getLow();
    }
    public BigDecimal getClosePrice(String symbol, String date){
        return getPrices(symbol,date).getClose();
    }
    public BigDecimal getVolumePrice(String symbol, String date){
        return getPrices(symbol,date).getVolume();
    }
}

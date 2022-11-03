package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final StockConverter stockConverter;
    public StockDto save(StockDto stockDto, String date, String symbol){
        stockRepository.save(stockConverter.convertToStock(stockDto,date,symbol));
        return null;
    }
}

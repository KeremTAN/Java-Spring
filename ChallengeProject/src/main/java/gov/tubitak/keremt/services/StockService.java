package gov.tubitak.keremt.services;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    public StockDto save(StockDto stockDto){
        Stock stock = new Stock();
       // stock.setOpen();
        return null;
    }
}

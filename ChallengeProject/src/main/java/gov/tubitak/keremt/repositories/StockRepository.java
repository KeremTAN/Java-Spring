package gov.tubitak.keremt.repositories;

import gov.tubitak.keremt.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, String> {
    Stock findBySymbolAndDate(String symbol, String date);
    List<Stock> findBySymbol(String symbol);
    List<Stock> findByDate(String date);
}

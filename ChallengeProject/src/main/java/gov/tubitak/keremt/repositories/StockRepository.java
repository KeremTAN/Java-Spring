package gov.tubitak.keremt.repositories;

import gov.tubitak.keremt.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {
}

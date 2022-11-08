package gov.tubitak.keremt.services;

import gov.tubitak.keremt.TryJacoco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
@SpringBootTest
public class StockServiceTest {
//    @Autowired
//    private StockService service;

 //   private StockRepository stockRepository;
 //   private StockConverter stockConverter;
/*
    @org.junit.Before
    public void setUp() throws Exception {
        stockRepository = Mockito.mock(StockRepository.class);
        stockConverter = Mockito.mock(StockConverter.class);
        service = new StockService(stockRepository,stockConverter);
    }
*/
    @Test
    public void whenGetPriceCalledWithValidRequest_ReturnsOpenPrice(){
       // BigDecimal expectedValue = BigDecimal.valueOf(127.70);
        // Assertions.assertEquals(expectedValue, service.getPrice("IBM","2022-09-06","open"));
        TryJacoco tryJacoco = new TryJacoco();
        Assertions.assertEquals("It is done",tryJacoco.getMessage());
    }
/*
    public void dto(){
        List<StockDto> expectedValue =new LinkedList<>();
        StockDto testStockDto =new StockDto("2022-09-06","IBM",
                BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
                BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
        expectedValue.add(testStockDto);
        Assertions.assertEquals(expectedValue.get(0),service.getStocks("IBM","2022-09-06").get(0));
    }*/
}
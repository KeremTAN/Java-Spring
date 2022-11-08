package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.repositories.StockRepository;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class StockServiceTest {
    private StockService service;

    private StockRepository stockRepository;
    private StockConverter stockConverter;

    @org.junit.Before
    public void setUp() throws Exception {
        stockRepository = Mockito.mock(StockRepository.class);
        stockConverter = Mockito.mock(StockConverter.class);
        service = new StockService(stockRepository,stockConverter);
    }

    @org.junit.jupiter.api.Test
    public void whenGetPriceCalledWithValidRequest_ReturnsOpenPrice(){
        BigDecimal expectedValue = BigDecimal.valueOf(127.70);
        Assert.assertEquals(expectedValue,service.getPrice("IBM","2022-09-06","open"));
    }
    @org.junit.jupiter.api.Test
    public void dto(){
        List<StockDto> expectedValue =new LinkedList<>();
        StockDto testStockDto =new StockDto("2022-09-06","IBM",
                BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
                BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
        expectedValue.add(testStockDto);
        Assert.assertEquals(expectedValue.get(0),service.getStocks("IBM","2022-09-06").get(0));

    }
}
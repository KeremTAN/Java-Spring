package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    @InjectMocks
    private StockService service;
    @Mock
    private StockRepository stockRepository;
    @Mock
    private StockConverter stockConverter;
    List<StockDto> testValue =new LinkedList<>();
    StockDto testStockDto =new StockDto("2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    Stock mockStock =new Stock(1L,"2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));

    public StockServiceTest() {
        testValue.add(testStockDto);
    }




    /** GetPrice Method*/
    @Test
    public void whenGetPriceCalledWithValidRequestTypeOpen_ReturnsOpenPrice(){
        Mockito.when(stockConverter.convertToStockDto(mockStock)).thenReturn(testStockDto);
        Mockito.when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockStock);
                                //testValue.get(0).getHigh()
        Assertions.assertEquals(BigDecimal.valueOf(127.80), service.getPrice("IBM","2022-09-06","open"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypHigh_ReturnsHighPrice(){
        Mockito.when(stockConverter.convertToStockDto(mockStock)).thenReturn(testStockDto);
        Mockito.when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockStock);
        Assertions.assertEquals(BigDecimal.valueOf(128.06), service.getPrice("IBM","2022-09-06","high"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeLow_ReturnsLowPrice(){
        Mockito.when(stockConverter.convertToStockDto(mockStock)).thenReturn(testStockDto);
        Mockito.when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockStock);
        Assertions.assertEquals(BigDecimal.valueOf(126.30), service.getPrice("IBM","2022-09-06","low"));
    }

    @Test
    public void whenGetPriceCalledWithValidRequestTypeClose_ReturnsClosePrice(){
        Mockito.when(stockConverter.convertToStockDto(mockStock)).thenReturn(testStockDto);
        Mockito.when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockStock);
        Assertions.assertEquals(BigDecimal.valueOf(126.72), service.getPrice("IBM","2022-09-06","close"));
    }

    @Test
    public void whenGetPriceCalledWithValidRequestTypeVolume_ReturnsVolume(){
        Mockito.when(stockConverter.convertToStockDto(mockStock)).thenReturn(testStockDto);
        Mockito.when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockStock);
        Assertions.assertEquals(BigDecimal.valueOf(3345343.00), service.getPrice("IBM","2022-09-06","volume"));
    }


    @Test
    public void whenGetPriceCalledWithValidRequestInValidType_ReturnsMinus1(){
        BigDecimal expectedValue = BigDecimal.valueOf(-1);
        Assertions.assertEquals(expectedValue, service.getPrice("IBM","2022-09-06","none"));
    }
}
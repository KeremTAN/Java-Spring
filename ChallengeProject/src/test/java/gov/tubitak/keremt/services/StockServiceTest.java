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
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    @InjectMocks
    private StockService service;
    @Mock
    private StockRepository stockRepository;
    @Mock
    private StockConverter stockConverter;
    List<StockDto> testStockDTOList =new LinkedList<>();
    List<Stock> mockStockList =new LinkedList<>();
    StockDto testFirstIBMStockDto =new StockDto("2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    StockDto testSecondIBMStockDto =new StockDto("2022-08-31","IBM",
            BigDecimal.valueOf(129.92),BigDecimal.valueOf(130.00),BigDecimal.valueOf(128.40),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(3490380.00));
    Stock mockFirstIBMStock =new Stock(1L,"2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    Stock mockSecondIBMStock =new Stock(2L, "2022-08-31","IBM",
            BigDecimal.valueOf(129.92),BigDecimal.valueOf(130.00),BigDecimal.valueOf(128.40),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(3490380.00));

    private void createIBMList(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testSecondIBMStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }
    private void createFirstIBMStockDTO(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
    }
    /** GetPrice Method*/
    @Test
    public void whenGetPriceCalledWithValidRequestTypeOpen_ReturnsOpenPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
                                //testValue.get(0).getHigh()
        Assertions.assertEquals(BigDecimal.valueOf(127.80), service.getPrice("IBM","2022-09-06","open"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypHigh_ReturnsHighPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        Assertions.assertEquals(BigDecimal.valueOf(128.06), service.getPrice("IBM","2022-09-06","high"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeLow_ReturnsLowPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        Assertions.assertEquals(BigDecimal.valueOf(126.30), service.getPrice("IBM","2022-09-06","low"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeClose_ReturnsClosePrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        Assertions.assertEquals(BigDecimal.valueOf(126.72), service.getPrice("IBM","2022-09-06","close"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeVolume_ReturnsVolume(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        Assertions.assertEquals(BigDecimal.valueOf(3345343.00), service.getPrice("IBM","2022-09-06","volume"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestInValidType_ReturnsMinus1(){

        BigDecimal expectedValue = BigDecimal.valueOf(-1);
        Assertions.assertEquals(expectedValue, service.getPrice("IBM","2022-09-06","none"));
    }
    /**
    @Test
    public void whenGetStocksCalledWithSymbol_ReturnsIBMList(){
        createIBMList();
        List<StockDto> check = new LinkedList<>();
        when(stockRepository.findBySymbol("IBM"))
                .thenReturn(mockStockList);
        doCallRealMethod().when(stockConverter).convertToAllAsStockDTO(check,mockStockList);
        Assertions.assertEquals(testStockDTOList, service.getStocks("IBM",null));
    }*/
}
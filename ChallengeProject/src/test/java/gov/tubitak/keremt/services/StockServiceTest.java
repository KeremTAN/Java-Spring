package gov.tubitak.keremt.services;

import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import gov.tubitak.keremt.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    /** TEST STOCKDTO OBJECTS **/
    StockDto testFirstIBMStockDto =new StockDto("2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    StockDto testSecondIBMStockDto =new StockDto("2022-08-31","IBM",
            BigDecimal.valueOf(129.92),BigDecimal.valueOf(130.00),BigDecimal.valueOf(128.40),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(3490380.00));
    StockDto testThirdAAPLStockDto =new StockDto("2022-09-06","AAPL",
            BigDecimal.valueOf(156.47),BigDecimal.valueOf(157.07),BigDecimal.valueOf(154.53),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(73295539.00));

    /** MOCK STOCK OBJECTS **/
    Stock mockFirstIBMStock =new Stock(1L,"2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    Stock mockSecondIBMStock =new Stock(2L, "2022-08-31","IBM",
            BigDecimal.valueOf(129.92),BigDecimal.valueOf(130.00),BigDecimal.valueOf(128.40),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(3490380.00));

    Stock mockThirdAAPLStock =new Stock(3L,"2022-09-06","AAPL",
            BigDecimal.valueOf(156.47),BigDecimal.valueOf(157.07),BigDecimal.valueOf(154.53),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(73295539.00));

    /** CREATE LISTS **/
    private void createFirstIBMStockDTO(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
    }
    private void createIBMList(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testSecondIBMStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }
    private void createDateList(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testThirdAAPLStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }
    private void createAllList() {
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testSecondIBMStockDto);
        testStockDTOList.add(testThirdAAPLStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }


    /*****  TESTS *****/

    /**
     ** GetPrice Method ***
     */
    @Test
    public void whenGetPriceCalledWithValidRequestTypeOpen_ReturnsOpenPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
                                //testValue.get(0).getHigh()
        assertEquals(BigDecimal.valueOf(127.80), service.getPrice("IBM","2022-09-06","open"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypHigh_ReturnsHighPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        assertEquals(BigDecimal.valueOf(128.06), service.getPrice("IBM","2022-09-06","high"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeLow_ReturnsLowPrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        assertEquals(BigDecimal.valueOf(126.30), service.getPrice("IBM","2022-09-06","low"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeClose_ReturnsClosePrice(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        assertEquals(BigDecimal.valueOf(126.72), service.getPrice("IBM","2022-09-06","close"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeVolume_ReturnsVolume(){
        createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        assertEquals(BigDecimal.valueOf(3345343.00), service.getPrice("IBM","2022-09-06","volume"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestInValidType_ReturnsMinus1(){

        BigDecimal expectedValue = BigDecimal.valueOf(-1);
        assertEquals(expectedValue, service.getPrice("IBM","2022-09-06","none"));
    }

    /**
     ** IsRepositoryEmpty Method ***
     */
    @Test
    public void whenIsRepositoryEmptyCalledWithFullElements_ReturnsFalse(){
        createIBMList();
        when(stockRepository.count()).thenReturn((long) mockStockList.size());
        assertEquals(2,stockRepository.count());
        assertFalse(service.isRepositoryEmpty());
    }
    @Test
    public void whenIsRepositoryEmptyCalledWithEmptyElements_ReturnsTrue(){
        mockStockList.clear();
        when(stockRepository.count()).thenReturn((long) mockStockList.size());
         assertEquals(0,stockRepository.count());
        assertTrue(service.isRepositoryEmpty());
    }

    /**
     ** GetStocks Method ***
     */
    @Test
    public void whenGetStocksCalledNullRequest_ReturnsAllElements(){
        createAllList();
        when(stockRepository.findAll())
                .thenReturn(mockStockList);
        when(stockConverter.convertToAllAsStockDTO(mockStockList))
                .thenReturn(testStockDTOList);
        assertEquals(testStockDTOList, service.getStocks(null,null));
    }
    @Test
    public void whenGetStocksCalledSymbolAndDate_ReturnsFirstIBMStockDTO(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mockFirstIBMStock);
        when(stockConverter.convertToStockDto(mockFirstIBMStock))
                .thenReturn(testFirstIBMStockDto);
        assertEquals(testStockDTOList, service.getStocks("IBM","2022-09-06"));
    }
    @Test
    public void whenGetStocksCalledWithSymbol_ReturnsIBMList(){
        createIBMList();
        when(stockRepository.findBySymbol("IBM"))
                .thenReturn(mockStockList);
        when(stockConverter.convertToAllAsStockDTO(mockStockList))
                .thenReturn(testStockDTOList);
        assertEquals(testStockDTOList, service.getStocks("IBM",null));
    }
    @Test
    public void whenGetStocksCalledWithDate_ReturnsDateList(){
        createDateList();
        when(stockRepository.findByDate("2022-09-06"))
                .thenReturn(mockStockList);
        when(stockConverter.convertToAllAsStockDTO(mockStockList))
                .thenReturn(testStockDTOList);
        assertEquals(testStockDTOList, service.getStocks(null,"2022-09-06"));
    }

    /**
     ** Save Method ***
     */
    @Test
    public void whenSaveCalled_ReturnsAllElements(){
        when(stockConverter.convertToStock(testFirstIBMStockDto,"2022-09-06","IBM"))
                .thenReturn(mockFirstIBMStock);
        assertEquals(testFirstIBMStockDto,service.save(testFirstIBMStockDto,"2022-09-06","IBM"));
    }
}
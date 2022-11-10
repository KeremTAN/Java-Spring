package gov.tubitak.keremt.services;

import gov.tubitak.keremt.MockObjects;
import gov.tubitak.keremt.converter.StockConverter;
import gov.tubitak.keremt.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;

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

    MockObjects mObj = new MockObjects();


    /***** TESTS *****/

    /**
     ** GetPrice Method ***
     */
    @Test
    public void whenGetPriceCalledWithValidRequestTypeOpen_ReturnsOpenPrice(){
        mObj.createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
        //testValue.get(0).getHigh()
        assertEquals(BigDecimal.valueOf(127.80), service.getPrice("IBM","2022-09-06","open"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypHigh_ReturnsHighPrice(){
        mObj.createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
        assertEquals(BigDecimal.valueOf(128.06), service.getPrice("IBM","2022-09-06","high"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeLow_ReturnsLowPrice(){
        mObj.createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
        assertEquals(BigDecimal.valueOf(126.30), service.getPrice("IBM","2022-09-06","low"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeClose_ReturnsClosePrice(){
        mObj.createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
        assertEquals(BigDecimal.valueOf(126.72), service.getPrice("IBM","2022-09-06","close"));
    }
    @Test
    public void whenGetPriceCalledWithValidRequestTypeVolume_ReturnsVolume(){
        mObj.createFirstIBMStockDTO();
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
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
        mObj.createIBMList();

        when(stockRepository.count())
                .thenReturn((long) mObj.getMockStockList().size());

        assertEquals(2,stockRepository.count());
        assertFalse(service.isRepositoryEmpty());
    }
    @Test
    public void whenIsRepositoryEmptyCalledWithEmptyElements_ReturnsTrue(){
        mObj.getMockStockList().clear();

        when(stockRepository.count())
                .thenReturn((long) mObj.getMockStockList().size());

        assertEquals(0,stockRepository.count());
        assertTrue(service.isRepositoryEmpty());
    }

    /**
     ** GetStocks Method ***
     */
    @Test
    public void whenGetStocksCalledNullRequest_ReturnsAllElements(){
        mObj.createAllList();

        when(stockRepository.findAll())
                .thenReturn(mObj.getMockStockList());
        when(stockConverter.convertToAllAsStockDTO(mObj.getMockStockList()))
                .thenReturn(mObj.getTestStockDTOList());
        assertEquals(mObj.getTestStockDTOList(), service.getStocks(null,null));
    }
    @Test
    public void whenGetStocksCalledSymbolAndDate_ReturnsFirstIBMStockDTO(){
        mObj.getTestStockDTOList().clear();
        mObj.getTestStockDTOList().add(mObj.getTestFirstIBMStockDto());

        when(stockRepository.findBySymbolAndDate("IBM","2022-09-06"))
                .thenReturn(mObj.getMockFirstIBMStock());
        when(stockConverter.convertToStockDto(mObj.getMockFirstIBMStock()))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        assertEquals(mObj.getTestStockDTOList(), service.getStocks("IBM","2022-09-06"));
    }
    @Test
    public void whenGetStocksCalledWithSymbol_ReturnsIBMList(){
        mObj.createIBMList();
        when(stockRepository.findBySymbol("IBM"))
                .thenReturn(mObj.getMockStockList());
        when(stockConverter.convertToAllAsStockDTO(mObj.getMockStockList()))
                .thenReturn(mObj.getTestStockDTOList());
        assertEquals(mObj.getTestStockDTOList(), service.getStocks("IBM",null));
    }
    @Test
    public void whenGetStocksCalledWithDate_ReturnsDateList(){
        mObj.createDateList();
        when(stockRepository.findByDate("2022-09-06"))
                .thenReturn(mObj.getMockStockList());
        when(stockConverter.convertToAllAsStockDTO(mObj.getMockStockList()))
                .thenReturn(mObj.getTestStockDTOList());
        assertEquals(mObj.getTestStockDTOList(), service.getStocks(null,"2022-09-06"));
    }

    /**
     ** Save Method ***
     */
    @Test
    public void whenSaveCalledWithValidRequest_ReturnsAllElements(){
        when(stockConverter.convertToStock(mObj.getTestFirstIBMStockDto(),"2022-09-06","IBM"))
                .thenReturn(mObj.getMockFirstIBMStock());
        assertEquals(mObj.getTestFirstIBMStockDto(),
                service.save(mObj.getTestFirstIBMStockDto(),"2022-09-06","IBM"));
    }
    @Test
    public void whenSaveCalledWithInValidRequest_ReturnsNull(){
        assertNull(service.save(mObj.getTestFirstIBMStockDto(), null, null));
    }
}
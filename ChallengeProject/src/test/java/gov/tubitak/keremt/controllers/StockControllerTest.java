package gov.tubitak.keremt.controllers;

import gov.tubitak.keremt.MockObjects;
import gov.tubitak.keremt.services.StockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockControllerTest {
    @InjectMocks
    private StockController controller;
    @Mock
    private StockService service;
    MockObjects mObj = new MockObjects();

    /**
     ** Get Stocks Method ***
     */

    @Test
    public void whenGetStocksCalledWithValidAllRequest_ReturnsFirstIBM(){
        mObj.getTestStockDTOList().clear();
        mObj.getTestStockDTOList().add(mObj.getTestFirstIBMStockDto());

        when(service.getStocks("IBM","2022-09-6"))
                .thenReturn(mObj.getTestStockDTOList());

        assertEquals(
                ResponseEntity.ok(mObj.getTestStockDTOList()),
                controller.getStocks("IBM","2022-09-6")
        );
    }
    @Test
    public void whenGetStocksCalledWithSymbolAndNoDate_ReturnsIBMList(){
        mObj.createIBMList();
        when(service.getStocks("IBM",null))
                .thenReturn(mObj.getTestStockDTOList());

        assertEquals(
                ResponseEntity.ok(mObj.getTestStockDTOList()),
                controller.getStocks("IBM",null)
        );
    }
    @Test
    public void whenGetStocksCalledWithNoSymbolAndDate_ReturnsDateList(){
        mObj.createDateList();
        when(service.getStocks("IBM",null))
                .thenReturn(mObj.getTestStockDTOList());

        assertEquals(
                ResponseEntity.ok(mObj.getTestStockDTOList()),
                controller.getStocks("IBM",null)
        );
    }
    @Test
    public void whenGetStocksCalledWithNoSymbolAndNoDate_ReturnsAllList() {
        mObj.createDateList();
        when(service.getStocks(null, null))
                .thenReturn(mObj.getTestStockDTOList());

        assertEquals(
                ResponseEntity.ok(mObj.getTestStockDTOList()),
                controller.getStocks(null, null)
        );
    }

    /**
     ** Get Price Method ***
     */
    @Test
    public void whenGetPriceCalledWithValidReqsTypeOpen_ReturnsOpenPrice(){
        when(service.getPrice("IBM","2022-09-6","open"))
                .thenReturn(mObj.getMockFirstIBMStock().getOpen());
        assertEquals(
                ResponseEntity.ok(BigDecimal.valueOf(127.80)),
                controller.getPrice("IBM","2022-09-6","open")
        );
    }
    @Test
    public void whenGetPriceCalledWithValidReqsTypeHigh_ReturnsHighPrice(){
        when(service.getPrice("IBM","2022-09-6","high"))
                .thenReturn(mObj.getMockFirstIBMStock().getHigh());
        assertEquals(
                ResponseEntity.ok(BigDecimal.valueOf(128.06)),
                controller.getPrice("IBM","2022-09-6","high")
        );
    }
    @Test
    public void whenGetPriceCalledWithValidReqsTypeLow_ReturnsLowPrice(){
        when(service.getPrice("IBM","2022-09-6","low"))
                .thenReturn(mObj.getMockFirstIBMStock().getLow());
        assertEquals(
                ResponseEntity.ok(BigDecimal.valueOf(126.30)),
                controller.getPrice("IBM","2022-09-6","low")
        );
    }
    @Test
    public void whenGetPriceCalledWithValidReqsTypeClose_ReturnsClosePrice(){
        when(service.getPrice("IBM","2022-09-6","close"))
                .thenReturn(mObj.getMockFirstIBMStock().getClose());
        assertEquals(
                ResponseEntity.ok(BigDecimal.valueOf(126.72)),
                controller.getPrice("IBM","2022-09-6","close")
        );
    }
    @Test
    public void whenGetPriceCalledWithValidReqsTypeVolume_ReturnsVolumePrice(){
        when(service.getPrice("IBM","2022-09-6","volume"))
                .thenReturn(mObj.getMockFirstIBMStock().getVolume());
        assertEquals(
                ResponseEntity.ok(BigDecimal.valueOf(3345343.00)),
                controller.getPrice("IBM","2022-09-6","volume")
        );
    }

    /**
     ** Save Method ***
     */
    @Test
    public void whenSaveCalledWithValidReqs_ReturnsStockDto(){
        when(service.save(mObj.getTestFirstIBMStockDto(),"2022-09-6","IBM"))
                .thenReturn(mObj.getTestFirstIBMStockDto());
        assertEquals(
                ResponseEntity.ok(mObj.getTestFirstIBMStockDto()),
                controller.save(mObj.getTestFirstIBMStockDto(),"IBM","2022-09-6")
        );
    }
    @Test
    public void whenSaveCalledWithDateNull_ReturnsNULL(){
        when(service.save(mObj.getTestFirstIBMStockDto(),null,"IBM"))
                .thenReturn(null);
        assertEquals(
                ResponseEntity.ok(null),
                controller.save(mObj.getTestFirstIBMStockDto(),"IBM",null)
        );
    }
    @Test
    public void whenSaveCalledWithSymbolNull_ReturnsNULL(){
        when(service.save(mObj.getTestFirstIBMStockDto(),"2022-09-6",null))
                .thenReturn(null);
        assertEquals(
                ResponseEntity.ok(null),
                controller.save(mObj.getTestFirstIBMStockDto(),null,"2022-09-6")
        );
    }
    @Test
    public void whenSaveCalledWithEmptyStockDto_ReturnsNull(){
        when(service.save(null,"2022-09-6","IBM"))
                .thenReturn(null);
        assertEquals(
                ResponseEntity.ok(null),
                controller.save(null,"IBM","2022-09-6")
        );
    }
}
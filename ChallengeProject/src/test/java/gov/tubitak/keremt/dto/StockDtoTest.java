package gov.tubitak.keremt.dto;

import gov.tubitak.keremt.MockObjects;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class StockDtoTest {
    MockObjects mObj = new MockObjects();
    StockDto stockDto = mObj.getTestFirstIBMStockDto();
    StockDto NoArgsConstructor = new StockDto();


    @Test
    void testSetDate() {
        stockDto.setDate("2022-12-30");
        assertEquals("2022-12-30", stockDto.getDate());
    }

    @Test
    void testSetSymbol() {
        stockDto.setSymbol("MBI");
        assertEquals("MBI", stockDto.getSymbol());
    }

    @Test
    void testSetOpen() {
        stockDto.setOpen(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stockDto.getOpen());
    }

    @Test
    void testSetHigh() {
        stockDto.setHigh(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stockDto.getHigh());
    }

    @Test
    void testSetLow() {
        stockDto.setLow(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stockDto.getLow());
    }

    @Test
    void testSetClose() {
        stockDto.setClose(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stockDto.getClose());
    }

    @Test
    void testSetVolume() {
        stockDto.setVolume(BigDecimal.valueOf(12354.9));
        assertEquals(BigDecimal.valueOf(12354.9), stockDto.getVolume());
    }

    @Test
    void testToString() {
        String s =
                "StockDto(date=2022-09-06, symbol=IBM, open=127.8, high=128.06," +
                " low=126.3, close=126.72, adjusted_close=11, volume=3345343.0)";
        assertEquals(s, stockDto.toString());
    }

}
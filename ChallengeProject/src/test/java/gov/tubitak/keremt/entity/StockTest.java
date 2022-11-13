package gov.tubitak.keremt.entity;

import gov.tubitak.keremt.MockObjects;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    MockObjects mObj = new MockObjects();
    Stock stock = mObj.getMockFirstIBMStock();
    Stock NoArgsConstructor = new Stock();

    @Test
    void testSetId() {
        stock.setId((123456789L));
        assertEquals(123456789L, stock.getId());
    }

    @Test
    void testSetDate() {
        stock.setDate("2022-12-30");
        assertEquals("2022-12-30", stock.getDate());
    }

    @Test
    void testSetSymbol() {
        stock.setSymbol("MBI");
        assertEquals("MBI", stock.getSymbol());
    }

    @Test
    void testSetOpen() {
        stock.setOpen(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stock.getOpen());
    }

    @Test
    void testSetHigh() {
        stock.setHigh(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stock.getHigh());
    }

    @Test
    void testSetLow() {
        stock.setLow(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stock.getLow());
    }

    @Test
    void testSetClose() {
        stock.setClose(BigDecimal.valueOf(123.54));
        assertEquals(BigDecimal.valueOf(123.54), stock.getClose());
    }

    @Test
    void testSetVolume() {
        stock.setVolume(BigDecimal.valueOf(12354.9));
        assertEquals(BigDecimal.valueOf(12354.9), stock.getVolume());
    }

    @Test
    void testToString() {
        String s =
                "Stock(id=0, date=2022-09-06, symbol=IBM, open=127.8, high=128.06," +
                 " low=126.3, close=126.72, adjusted_close=11, volume=3345343.0)";
        assertEquals(s, stock.toString());
    }
}
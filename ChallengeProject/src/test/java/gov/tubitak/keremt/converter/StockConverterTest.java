
package gov.tubitak.keremt.converter;


import gov.tubitak.keremt.MockObjects;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockConverterTest {
    private StockConverter converter = new StockConverter();
    MockObjects mObj = new MockObjects();

    /***** TESTS ****/
    @Test
    public void whenConvertToStockCalledValidRequest_ReturnsStock(){
        assertEquals(
                mObj.getMockFirstIBMStock(),
                converter.convertToStock(mObj.getTestFirstIBMStockDto(),"2022-09-06","IBM"));
    }

    @Test
    public void whenConvertToStockDTOCalledValidRequest_ReturnsStockDTO(){
        assertEquals(
                mObj.getTestFirstIBMStockDto(),
                converter.convertToStockDto(mObj.getMockFirstIBMStock()));
    }

    @Test
    public void convertToAllAsStockDTOCalledValidRequest_ReturnsAllStockDTO(){
        mObj.createAllList();
        assertEquals(
                mObj.getTestStockDTOList().get(0),
                converter.convertToAllAsStockDTO(mObj.getMockStockList()).get(0));
    }
}


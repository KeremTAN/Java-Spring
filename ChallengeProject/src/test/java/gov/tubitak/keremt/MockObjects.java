package gov.tubitak.keremt;

import gov.tubitak.keremt.dto.StockDto;
import gov.tubitak.keremt.entity.Stock;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class MockObjects {
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
    Stock mockFirstIBMStock =new Stock(0L,"2022-09-06","IBM",
            BigDecimal.valueOf(127.80),BigDecimal.valueOf(128.06),BigDecimal.valueOf(126.30),
            BigDecimal.valueOf(126.72), BigDecimal.valueOf(3345343.00));
    Stock mockSecondIBMStock =new Stock(1L, "2022-08-31","IBM",
            BigDecimal.valueOf(129.92),BigDecimal.valueOf(130.00),BigDecimal.valueOf(128.40),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(3490380.00));

    Stock mockThirdAAPLStock =new Stock(2L,"2022-09-06","AAPL",
            BigDecimal.valueOf(156.47),BigDecimal.valueOf(157.07),BigDecimal.valueOf(154.53),
            BigDecimal.valueOf(128.45), BigDecimal.valueOf(73295539.00));

    /** CREATE LISTS **/
    public void createFirstIBMStockDTO(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
    }
    public void createIBMList(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testSecondIBMStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }
    public void createDateList(){
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testThirdAAPLStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }
    public void createAllList() {
        testStockDTOList.clear();
        testStockDTOList.add(testFirstIBMStockDto);
        testStockDTOList.add(testSecondIBMStockDto);
        testStockDTOList.add(testThirdAAPLStockDto);
        mockStockList.clear();
        mockStockList.add(mockFirstIBMStock);
        mockStockList.add(mockSecondIBMStock);
        mockStockList.add(mockSecondIBMStock);
    }

}

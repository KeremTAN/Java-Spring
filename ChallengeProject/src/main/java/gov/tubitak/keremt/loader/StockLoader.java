package gov.tubitak.keremt.loader;

import java.math.BigDecimal;

public class StockLoader {
    BigDecimal[] opens= {
            BigDecimal.valueOf(138.2500), BigDecimal.valueOf(138.0600),
            BigDecimal.valueOf(135.5600), BigDecimal.valueOf(135.5500),
            BigDecimal.valueOf(133.7200), BigDecimal.valueOf(132.0000),
            BigDecimal.valueOf(130.9000)};
    BigDecimal[] high= {
            BigDecimal.valueOf(138.6500), BigDecimal.valueOf(138.7699),
            BigDecimal.valueOf(138.8615), BigDecimal.valueOf(136.4000),
            BigDecimal.valueOf(135.8630), BigDecimal.valueOf(133.3000),
            BigDecimal.valueOf(133.1100)};
    BigDecimal[] low= {
            BigDecimal.valueOf(136.7000), BigDecimal.valueOf(136.5950),
            BigDecimal.valueOf(135.2200), BigDecimal.valueOf(134.4450),
            BigDecimal.valueOf(132.8100), BigDecimal.valueOf(131.3000),
            BigDecimal.valueOf(129.8500)};

    BigDecimal[] close= {
            BigDecimal.valueOf(138.2000), BigDecimal.valueOf(138.2900),
            BigDecimal.valueOf(138.5100), BigDecimal.valueOf(134.7700),
            BigDecimal.valueOf(135.0100), BigDecimal.valueOf(132.9300),
            BigDecimal.valueOf(132.6900)};

    BigDecimal[] volume= {
            BigDecimal.valueOf(3590607), BigDecimal.valueOf(4915270),
            BigDecimal.valueOf(5965457), BigDecimal.valueOf(3993168),
            BigDecimal.valueOf(5140023), BigDecimal.valueOf(5957623),
            BigDecimal.valueOf(5610914)};
    public BigDecimal[] getOpen(){
        return opens;
    }
    public BigDecimal[] getHigh(){
        return high;
    }
    public BigDecimal[] getLow(){
        return low;
    }
    public BigDecimal[] getClose(){
        return close;
    }
    public BigDecimal[] getVolume(){
        return volume;
    }
}

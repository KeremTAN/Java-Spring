package gov.tubitak.keremt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StockDto {
    String date;
    String symbol;
    @JsonProperty("1. open")
    BigDecimal open;

    @JsonProperty("2. high")
    BigDecimal high;

    @JsonProperty("3. low")
    BigDecimal low;

    @JsonProperty("4. close")
    BigDecimal close;

    @JsonProperty("5. adjusted close")
    BigDecimal adjusted_close;

    @JsonProperty("6. volume")
    BigDecimal volume;
}

package gov.tubitak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {
    String symbol = "IBM";

//    @JsonProperty("1. open")
    BigDecimal open;

//    @JsonProperty("2. high")
    BigDecimal high;

//    @JsonProperty("3. low")
    BigDecimal low;

//    @JsonProperty("4. close")
    BigDecimal close;

//    @JsonProperty("5. volume")
    BigDecimal volume;
}
